package com.sise.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.util.CompareFile;

public class RejudgeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7686567547639725717L;
    private static String cmdpath = "D:/JudgeOnline/bin/gcc/bin/gcc";
	private static String inputpath = "D:/data/temp/temp.c";
	private static String outputpath = "D:/data/temp/temp";
    private static String linkrs = "D:/data/temp/link.txt";
    private static String in="D:/data/temp/in.in";
    private static String out = "D:/data/temp/out.out";
    private static String inPath = "D:/data/temp/input.in";
    
	public String run() throws Exception{
		
		File f = new File(inputpath);
		Runtime  runtime  = Runtime.getRuntime();
		//编译
		Process p = runtime.exec(cmdpath + " "+ f.getAbsolutePath() + " -o  "+ outputpath );
		
		String linked = readProcessOutput(p);//编译后返回的信息
		if(linked.length() == 0){
			//编译成功
			System.out.println("编译成功!");
			
			//把预输入的写到inputpath文件中
			write(inPath,"1");
			
			System.out.println(outputpath + " < " + inPath);
			
			long startTime=System.currentTimeMillis();
			//运行程序
			p = runtime.exec(outputpath + " <" + inPath);
			
			long endTime=System.currentTimeMillis(); 
			System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
			
			
			
			
			//输入
			writeprocessInput(p,"0");
			
			String runrs = readProcessOutput(p);
			//把执行程序结果写入文件
			write(in,runrs);
			
			//再把题目的预期结果写入文件
			write(out,"1");
			
			//对比两个文件是否相同
			if(CompareFile.isFileContentEqual(in, out))
				System.out.println("accept");
			else
				System.out.println("wrong answer");
			
			//清空两个文件
		}else
		{
			//编译失败
			System.out.println("编译失败!");
			
			//编译失败结果写入文本
			writelink(linkrs,linked);
			System.out.println(linked);
		}

		
		p.waitFor();
		p.destroy();
////		//运行
//		p = runtime.exec(outputpath);
//		String s = readProcessOutput(p);
//		
//		
//		 writelink(linkrs,s);
		
		return null;
	}
	
	
	public static void writelink(String filePath, String content) {
        BufferedWriter bw = null;
        
        try {
            // 根据文件路径创建缓冲输出流
            bw = new BufferedWriter(new FileWriter(filePath));
            // 将内容写入文件中
            bw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }
    }
	
	
	public static void write(String filePath, String content) {
        BufferedWriter bw = null;
        
        try {
            // 根据文件路径创建缓冲输出流
            bw = new BufferedWriter(new FileWriter(filePath));
            // 将内容写入文件中
            bw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }
    }
	
	
	private static void writeprocessInput(final Process process,String input){
		try {
			process.getOutputStream().write(input.getBytes());
			process.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String readProcessOutput(final Process process) {
		try {
			process.getOutputStream().close();
		} catch (IOException e) {
			System.out.println("输出流已经关闭");
		}finally{
        // 将进程的正常输出在 System.out 中打印，进程的错误输出在 System.err 中打印
        String rs = read(process.getInputStream(), System.out);
        rs += read(process.getErrorStream(), System.err);
        return rs;
		}
		
		
    }

	
	
    // 读取输入流
    private static String read(InputStream inputStream, PrintStream out) {
    	String content="";
    	int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
//                out.println(line);
            	if(count == 0)
            		content +=line;
            	else
            		content += "\r\n" + line;
            	count++;
            }

           
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return content;
    }
    
    

}
