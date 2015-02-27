package com.sise.action;

import java.sql.Timestamp;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Users;
import com.sise.service.imp.UsersService;

public class UsersAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//users控制层对象
	private UsersService usersService;
	
	private String userName;//页面的用户id
	private String password;//页面传来的密码
	private String msg;//返回信息
	private String nickName;//小名
	private String school;//学校
	private String email;//邮箱
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
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
		Users user = new Users();
		
		//把页面填写的密码和用户名赋值给该对象的userName和password属性
		user.setUserId(userName);
		user.setPassword(password);
		
		//判断用户是否存在
		if(usersService.hasUser(user)){
			//根据用户名密码登陆
			if(usersService.loginUser(user)){
				msg = "登陆成功";
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
				user = usersService.getUserByUserId(user);
				session.put("user", user);	
				return "loginOk";
			}else{
				msg="用户密码不正确";
				return "loginFail";
			}
				
		}
		else{
			msg="用户不存在";
		return "loginFail";	
		}
	}
	
	
	/**
	 * 注册用户
	 * @throws Exception 
	 */
	public String register() throws Exception{
		
		//实力一个空的tbUser对象
		Users user = new Users();
		user.setUserId(userName);
		user.setPassword(password);
		user.setNick(nickName);
		user.setSchool(school);
		user.setEmail(email);
		user.setSolved(0);
		user.setSubmit(0);
		user.setAccesstime(new Timestamp(System.currentTimeMillis()));
	
		
		
		//查看用户是否存在
		if(usersService.hasUser(user)){
			msg="用户id已存在,请重新输入!";
			return "registerFali";
		}
		
		//注册用户
		usersService.register(user);
		System.out.println("用户id为："+userName+"注册成功");
		
		msg="请登录！";
		
		return null;
	}
	
	
	/**
	 * 查看用户是否登陆
	 * @throws Exception 
	 */
	
	public String loginCheck()throws Exception{
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Users user = (Users)session.get("user");
		if(null == user){
			msg ="请登录";
			return "loginFail";
		}
		
		
		return "isNotLogin";
	}

	/**
	 * 注销用户
	 * @throws Exception 
	 */
	public String logout(){
		//获取上下文对象
		ActionContext actionContext = ActionContext.getContext();
		//获取会话对象
		Map session = actionContext.getSession();
		//移除已登陆的用户信息
		session.remove("user");
		msg = "请登陆!";
		return "logout";
	}
	
	/**
	 * 更新用户信息
	 */
	public String updateUser(){
		//获取上下文对象
		ActionContext actionContext = ActionContext.getContext();
		//获取会话对象
		Map session = actionContext.getSession();
		//获取登陆用户对象
		Users user = (Users)session.get("user");
		
		user.setPassword(password);
		user.setEmail(email);
		user.setNick(nickName);
		user.setSchool(school);
		
		usersService.update(user);
		
		logout();
		
		return "loginFail";
	}
	
}
