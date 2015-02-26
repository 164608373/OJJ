package com.sise.action;

import java.util.ArrayList;

import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.TbUser;
import com.sise.pojo.TbUserDetail;
import com.sise.service.imp.TbUserDetailService;
import com.sise.service.imp.TbUserService;
import com.sise.util.UserInfo;
import com.sise.util.Util;

public class TbUserDetailAction extends ActionSupport {
	//tb_user_detail控制层对象
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TbUserDetailService tbUserDetailService;//tb_user_detail服务层对象

	private TbUserService tbUserService;//tb_user服务层对象
	
	private ArrayList<UserInfo> userInfos;//查询用户所有信息存放该表所有数据的集合
	private String sex;//页面传来的用户的性别
	private String phone;//页面传来的用户的电话
	private String age;//页面传来的用户的年龄
	private String addDate;//页面传来的用户的加入时间
	private String userName;//页面传来的用户名字
	private String user_id;//页面传来的用户id
	private TbUserDetail tbUserDetail;//存放返回页面的用户对象
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public TbUserDetail getTbUserDetail() {
		return tbUserDetail;
	}

	public void setTbUserDetail(TbUserDetail tbUserDetail) {
		this.tbUserDetail = tbUserDetail;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public ArrayList<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(ArrayList<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public void setTbUserDetailService(TbUserDetailService tbUserDetailService) {
		this.tbUserDetailService = tbUserDetailService;
	}

	/**
	 * 查询tb_user_detail全部数据
	 */
	
	public String queryAll(){
		//调用全部查询服务并且返回到页面
		userInfos = tbUserDetailService.queryAllService();
		
		return "queryAllOk";
	}
	
	/**
	 * 添加用户详细信息动作
	 * 1.先根据用户名判断该用户是否存在   是（返回用户存在信息） 否（跳到2）
	 * 2.根据页面的传来的值添加到数据库，不单止添加到tb_user_detail表，而且要添加到tb_user表中
	 * 
	 * @throws Exception 
	 */
	
	public String addUserDetail() throws Exception{
		if(addDate == null){
			addDate = new String();
		}
		userName = new String(userName.getBytes("iso8859-1"), "utf-8");
		addDate = new String(addDate.getBytes("iso8859-1"), "utf-8");
		//实例化一个空的user_detail对象
		TbUserDetail ud = new TbUserDetail();
		//把要增加的用户信息设置进去该空对象之中
				ud.setId(Integer.valueOf(tbUserDetailService.getMaxIdService()));
				ud.setUserName(userName);
				ud.setAddDate(addDate);
				ud.setAge(age);
				ud.setPhone(phone);
				ud.setSuccess("0");
				ud.setSex(sex);
				
				//根据用户名判断用户是否存在  是（返回用户存在） 否（继续执行）
				boolean is = tbUserDetailService.hasUserDetailService(ud);
				if(is == true){
					Util.printMessage("该用户已存在！");
					return null;
				}
				
				//调用添加服务
				tbUserDetailService.addUserService(ud);
				
				
				//实例化一个user对象
				TbUser tbuser = new TbUser();
				tbuser.setId(ud.getId());
				tbuser.setUserName(ud.getUserName());
				tbuser.setPassword("123");//设置起始密码为123
				tbuser.setNumber("0");//设置当前密码错误次数为0
				tbuser.setFlag("0");//设置当前状态为未锁上
				
				//添加到tb_user表中
				tbUserService.addUserService(tbuser);
				
				
				Util.printMessage("添加成功！该用户初始密码为123！");
		
		return null;
	}

	/**
	 * 前提:用户存在
	 * 根据用户id获取用户详细信息对象
	 * @return
	 * @throws Exception 
	 */
	public String loadUserDetail() throws Exception{
		System.out.println(user_id);
		//直接调用根据用户id获取用户服务,注意该服务是有前提的，前提是用户存在
		tbUserDetail = tbUserDetailService.getUserDetailByIdService(Integer.valueOf(user_id));
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", tbUserDetail.getId());
		jsonObj.put("username", tbUserDetail.getUserName());
		jsonObj.put("addDate", tbUserDetail.getAddDate());
		jsonObj.put("age", tbUserDetail.getAge());
		jsonObj.put("phone", tbUserDetail.getPhone());
		jsonObj.put("sex", tbUserDetail.getSex());
		
		//返回页面
		Util.printMessage(jsonObj.toString());
		
		return null;
	}
	
	
	/**
	 * 前提：用户存在
	 * 删除用户动作
	 * @throws Exception 
	 */
	public String deleteUser() throws Exception{
		//根据用户id获取用户详细对象
		TbUserDetail t = tbUserDetailService.getUserDetailByIdService(Integer.valueOf(user_id));
		
		
		
		//获取用户对象
		TbUser u = tbUserService.getUserById(t.getId());
		
		//由于tb_user的id是外键所以先删除tb_user的数据，再删出tb_user_detail的数据
		tbUserService.deleteUserService(u);
		
		//调用删除服务
		tbUserDetailService.deleteUserDeatil(t);
		
		//返回页面删除成功信息
		Util.printMessage("删除用户id为:"+user_id+"成功！");
		
		return null;
	}
	
	/**
	 * 更新用户动作
	 * @throws Exception 
	 */
	public String updateUser() throws Exception{
		//实例化一个空的对象存放更新数据的信息
		TbUserDetail t = new TbUserDetail();
		
		//转码
		userName = new String(userName.getBytes("iso8859-1"), "utf-8");
		
		//把页面更新用户的信息传到该对象
		t.setId(Integer.valueOf(user_id));
		t.setUserName(userName);
		t.setAddDate(addDate);
		t.setAge(age);
		t.setPhone(phone);
		t.setSex(sex);

		//更新用户详细信息
		tbUserDetailService.updateUserDetailByIdService(t);
		
		TbUser u = new TbUser();
		u.setId(Integer.valueOf(user_id));
		u.setUserName(userName);
		
		//同时更新用户的用户名
		tbUserService.updateUser(u);
		
		return null;
	}
}
