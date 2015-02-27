package com.sise.util;


/**
 * 
 * @author saber
 *
 */
public class Util {
	/**
	 * 输出信息到请求方
	 * @param message
	 * @throws Exception
	 */
	public static void printMessage(String message) throws Exception{
		StrutsUtil.getRequest().setCharacterEncoding("UTF-8");
		StrutsUtil.getResponse().setCharacterEncoding("UTF-8");
		StrutsUtil.getOut().print(message);
		StrutsUtil.getOut().flush();
		StrutsUtil.getOut().close();
	}
	
	
	

	
}
