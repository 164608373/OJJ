package com.sise.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
/**
 * struts2工具
 * @author lion
 *
 */
public class StrutsUtil {
	/**
	 * 获取request
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 获取response
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 获取session
	 * @return
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	/**
	 * 获取application
	 * @return
	 */
	public static ServletContext getApplication(){
		return getSession().getServletContext();
	}
	/**
	 * 获取PrintWriter
	 * @return
	 * @throws IOException
	 */
	public static PrintWriter getOut() throws IOException{
		return getResponse().getWriter();
	}
	
	
	
	
	
}
