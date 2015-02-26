package com.sise.service;

import java.util.ArrayList;

import com.sise.pojo.TbUser;
import com.sise.pojo.TbUserDetail;
import com.sise.util.UserInfo;

public interface ITbUserDetailService {
//tb_user_detail服务层接口
	
	/**
	 * 查询全部tb_user_detail
	 * @return
	 */
	public ArrayList<UserInfo> queryAllService();
	
	/**
	 * 根据用户名称获取用户信息对象
	 */
	public TbUserDetail getUserDetailByUserNameService(TbUserDetail t);
	
	/**
	 * 更新用户详细信息服务
	 */
	public void updateUserDetailByIdService(TbUserDetail t);
	
	/**
	 * 获取用户详细信息最大id
	 */
	public int getMaxIdService();
	
	/**
	 * 根据用户名判断用户详细信息是否存在
	 * 存在返回true
	 * 不存在返回false
	 */
	public boolean hasUserDetailService(TbUserDetail t);
	
	/**
	 * 根据用户id获取用户详细信息
	 */
	public TbUserDetail getUserDetailByIdService(Integer id);
	
	/**
	 * 删除用户详细信息
	 */
	public void deleteUserDeatil(TbUserDetail t);
}
