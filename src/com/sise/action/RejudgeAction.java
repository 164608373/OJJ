package com.sise.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Compileinfo;
import com.sise.pojo.Problem;
import com.sise.pojo.Users;
import com.sise.service.imp.CompileinfoService;
import com.sise.service.imp.ProblemService;
import com.sise.util.CompareFile;
import com.sise.util.FileTool;

public class RejudgeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7686567547639725717L;
	private  String problem_id;
	private ProblemService problemService;
	private CompileinfoService compileinfoService;
	private String submitCode;
    private static String cmdpath = "D:/JudgeOnline/bin/gcc/bin/gcc";
	private static String inputpath = "D:/data/temp/temp.c";
	private static String outputpath = "D:/data/temp/temp";
    private static String linkrs = "D:/data/temp/link.txt";
    private static String out = "D:/data/temp/out.out";
    
    
    
	public String getSubmitCode() {
		return submitCode;
	}


	public void setSubmitCode(String submitCode) {
		this.submitCode = submitCode;
	}


	public CompileinfoService getCompileinfoService() {
		return compileinfoService;
	}


	public void setCompileinfoService(CompileinfoService compileinfoService) {
		this.compileinfoService = compileinfoService;
	}


	public ProblemService getProblemService() {
		return problemService;
	}


	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}


	public  String getProblem_id() {
		return problem_id;
	}


	public  void setProblem_id(String problem_id) {
		this.problem_id = problem_id;
	}


	public String run() throws Exception{
		//获取会话层的user对象是否存在判断用户是否登陆
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Users user = (Users)session.get("user");
		
		if(null == user)
			return "submitFail";
		
		//实例化一个编译信息
		Compileinfo compileinfo = new Compileinfo();
		compileinfo.setUserId(Integer.valueOf(user.getUserId()));
		compileinfo.setSubmitTime(new Timestamp(System.currentTimeMillis()));
		compileinfo.setProblemId(Integer.valueOf(problem_id));
		compileinfo.setLanguage("gcc");
<<<<<<< HEAD
		
		//根据问题ID获取问题对象
		Problem problem = problemService.queryProblem(problem_id);
		
=======
		
		//根据问题ID获取问题对象
		Problem problem = problemService.queryProblem(problem_id);
		
>>>>>>> origin/master
		//把提交的代码写入inputpath = "D:/data/temp/temp.c"文件中
		write(inputpath, submitCode+"\r\n");
		
		if(submitCode.length() == 0){
			System.out.println("提交代码不能为空！");
			return null;
		}
		
		//实例输入文件对象
		File f = new File(inputpath);
		Runtime  runtime  = Runtime.getRuntime();
		
		Long codelength = new Long(f.length());
		
		//编译
		Process p = runtime.exec(cmdpath + " "+ f.getAbsolutePath() + " -o  "+ outputpath );
		
		String linked = readProcessOutput(p);//编译后返回的信息
		
		if(linked.length() == 0){
			//编译成功
			System.out.println("编译成功!");
			
<<<<<<< HEAD
			/**
			 * 根据问题id找出测试用的测试输入输出用例
			 */
			String testdirpath = "D:\\data\\test\\"+problem_id;
=======
			//把预输入的写到inputpath文件中
			write(inPath,problem.getSampleInput());
>>>>>>> origin/master
			
			FileTool fileTool = new FileTool();
			
			int dirlength = fileTool.getDirLength(testdirpath);
			
<<<<<<< HEAD
			int testRound = 0;
			
			if(dirlength == 2)
				testRound = 1;
			else if(dirlength == 4)
				testRound = 2;
			else if(dirlength == 6)
				testRound = 3;
			
			long start = 0;
			long end = 0;
			Long run = new Long(0) ;
			boolean flag = false; //对比结果
			
			//开始测试
			for (int i = 0; i < testRound; i++) {
				//开始时间
				start=System.currentTimeMillis();
				//测试输入文件路径
				String testinpath = testdirpath+"\\"+String.valueOf(i+1)+".in";
				//测试输出文件路径
				String testoutpath = testdirpath+"\\"+String.valueOf(i+1)+".out";
				System.out.println("测试第"+String.valueOf(i+1)+"次执行程序!");
				//执行程序
				p = runtime.exec(outputpath + " <" + testinpath);
				//测试输入
				writeprocessInput(p,fileTool.getFileContent(testinpath));
				//测试输出
				String rs = readProcessOutput(p);
				write(out,rs);
				
				//结束时间
				end=System.currentTimeMillis();
				System.out.println("执行第一次完毕，耗时"+(end-start)+"ms");
				//计算运行时间
				if(run < end - start)
					run = end - start;//运行时间
				
				if(CompareFile.isFileContentEqual(out, testoutpath)){
					flag = true;
				}
			}
			
			//标记
			
//			//把输入的写到inputpath文件中
//			write(inPath,problem.getSampleInput());
//			
//			System.out.println("执行程序!");
//			
//			long startTime=System.currentTimeMillis();
//			//运行程序
//			p = runtime.exec(outputpath + " <" + inPath);
//			
//			long endTime=System.currentTimeMillis(); 
//			
//			Long runTime=endTime-startTime;
//			
//			System.out.println("程序运行时间： "+runTime+"ms");
//			//输入
//			writeprocessInput(p,problem.getSampleInput());
//			
//			String runrs = readProcessOutput(p);
//			//把执行程序结果写入文件
//			write(in,runrs);
//			
//			//再把题目的预期结果写入文件
//			write(out,problem.getSampleOutput());
//			
			//判断是否超过限制时间
			if(problem.getTimeLimit() < run.intValue()){
				compileinfo.setError("");
				compileinfo.setResult(3);
				compileinfo.setTime(run.intValue());
				compileinfo.setCodeLength(codelength.intValue());
				compileinfoService.addComp(compileinfo);
				System.out.println("Output Limit Exceeded");
				return null;
			}
=======
			long endTime=System.currentTimeMillis(); 
			
			Long runTime=endTime-startTime;
			
			System.out.println("程序运行时间： "+runTime+"ms");
			//输入
			writeprocessInput(p,problem.getSampleInput());
			
			String runrs = readProcessOutput(p);
			//把执行程序结果写入文件
			write(in,runrs);
			
			//再把题目的预期结果写入文件
			write(out,problem.getSampleOutput());
>>>>>>> origin/master
			
			//判断是否超过限制时间
			if(problem.getTimeLimit() < runTime.intValue()){
				compileinfo.setError("");
				compileinfo.setResult(3);
				compileinfo.setTime(runTime.intValue());
				compileinfo.setCodeLength(codelength.intValue());
				compileinfoService.addComp(compileinfo);
				System.out.println("Output Limit Exceeded");
				return null;
			}
			
				
			//对比两个文件是否相同
<<<<<<< HEAD
			if(flag){
				compileinfo.setError("");
				compileinfo.setResult(1);
				compileinfo.setTime(run.intValue());
=======
			if(CompareFile.isFileContentEqual(in, out)){
				compileinfo.setError("");
				compileinfo.setResult(1);
				compileinfo.setTime(runTime.intValue());
>>>>>>> origin/master
				compileinfo.setCodeLength(codelength.intValue());
				compileinfoService.addComp(compileinfo);
				System.out.println("accept");
				return null;
			}
			else{
				compileinfo.setError("");
				compileinfo.setResult(2);
				compileinfo.setCodeLength(codelength.intValue());
<<<<<<< HEAD
				compileinfo.setTime(run.intValue());
=======
				compileinfo.setTime(runTime.intValue());
>>>>>>> origin/master
				compileinfoService.addComp(compileinfo);
				System.out.println("wrong answer");
				return null;
			}
			
			//清空两个文件
		}else
		{
			//保存编译失败信息
			compileinfo.setError(linked);
			compileinfo.setResult(0);
			compileinfo.setTime(0);
			compileinfo.setCodeLength(codelength.intValue());
			compileinfoService.addComp(compileinfo);
			
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
