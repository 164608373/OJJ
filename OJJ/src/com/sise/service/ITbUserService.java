package com.sise.service;

import com.sise.pojo.TbUser;

public interface ITbUserService {
	//tb_user服务层接口
	
	/**
	 * 前提：用户存在
	 * 用户登陆服务,用户输入密码错误系统将number字段+1,判断是否等于3
	 * 等于3系统就把number更新为0,并将flag更新为1(带表已经上锁)
	 * @return
	 */
	public int loginService(TbUser t);
	
	
	/**
	 * 判断用户是否存在
	 * 存在返回true,反之返回false;
	 * @return
	 */
	public boolean hasUser(TbUser t);
	
	
	/**
	 * 根据用户名获取用户对象
	 */
	public TbUser getUserByUserName(TbUser t);
	
	
	/**
	 * 根据用户id获取用户对象
	 */
	public TbUser getUserById(TbUser t);

	/**
	 * 根据用户id进行解锁
	 * @param t
	 */
	public String openLock(TbUser t);
	
	/**
	 * 添加用户服务
	 */
	
	public void addUserService(TbUser t);
	
	/**
	 * 删除用户服务
	 * @param t
	 */
	public void deleteUserService(TbUser t);
	
	/**
	 * 根据用户id获取用户对象
	 */
	public TbUser getUserById(Integer i);
	
	/**
	 * 更新用户名
	 * @param t
	 */
	public void updateUser(TbUser t);
}
