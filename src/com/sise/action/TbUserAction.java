package com.sise.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.TbUser;
import com.sise.service.imp.TbUserService;
import com.sise.util.Util;

public class TbUserAction extends ActionSupport{

	//tb_user控制层对象
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;//页面的用户名
	private String password;//页面传来的密码
	private String msg;//返回信息
	private String id;//页面传来的用户id
	
	
	private TbUserService tbUserService;//tb_user服务层对象
	
	
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * 登陆动作
	 * @throws Exception 
	 */
	public String login() throws Exception{
		//转码一下
		userName = new String(userName.getBytes("iso8859-1"), "utf-8");
		
		//实力一个空的tbUser对象
		TbUser tbUser =new TbUser();
		//把页面填写的密码和用户名赋值给该对象的userName和password属性
		tbUser.setUserName(userName);
		tbUser.setPassword(password);
		
		
		int loginFlag =tbUserService.loginService(tbUser);
		
		
		/**
		 * 
		 * 用户登陆服务,用户输入密码错误系统将number字段+1,判断是否等于3
		 * 等于3系统就把number更新为0,并将flag更新为1(带表已经上锁)
		 * 返回参数有4个
		 * 0 为登陆成功！     1 为密码错误       2为该用户被锁定请与管理员联系  3为该用户不存在
		 * @return
		 */
		if(0 == loginFlag){
			Util.printMessage("0");
			msg = "用户登陆成功！";
		}else if(1 == loginFlag){
			Util.printMessage("1");
			msg = "用户密码错误";

		}else if(2 == loginFlag){
			Util.printMessage("2");
			msg = "该用户已被锁定，请与管理员联系";
		}else if(3 == loginFlag){
			Util.printMessage("3");
			msg = "用户不存在";
		}
		
		
		return null;
	}
	
	
	/**
	 * 解锁动作
	 */
	
	public String openLock(){
		//实例化一个空的tbUser对象
		TbUser u = new TbUser();
		//把要解锁的用户的id设置在对象中
		u.setId(Integer.valueOf(id));
		
		//调用解锁服务
		String rs = tbUserService.openLock(u);
		
		//向页面发送信息
		try {
			Util.printMessage(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}
