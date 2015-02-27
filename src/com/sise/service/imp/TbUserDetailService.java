package com.sise.service.imp;

import java.util.ArrayList;

import com.sise.dao.ITbUserDetailDao;
import com.sise.pojo.TbUser;
import com.sise.pojo.TbUserDetail;
import com.sise.service.ITbUserDetailService;
import com.sise.service.ITbUserService;
import com.sise.util.UserInfo;

public class TbUserDetailService implements ITbUserDetailService{
//tb_user_detail服务层实现层
	private ITbUserDetailDao tbUserDetailDao;//tb_user_detail数据持久层对象

	private ITbUserService tbUserService;//tb_userservice服务层对象
	
	public void setTbUserService(ITbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public void setTbUserDetailDao(ITbUserDetailDao tbUserDetailDao) {
		this.tbUserDetailDao = tbUserDetailDao;
	}

	/**
	 * 查询全部tb_user_detail
	 */
	public ArrayList<UserInfo> queryAllService() {
		ArrayList<TbUserDetail> ud = (ArrayList<TbUserDetail>) tbUserDetailDao.query("From TbUserDetail");
		ArrayList<UserInfo> userinfos = new ArrayList<UserInfo>();
		for (TbUserDetail tbUserDetail : ud) {
			UserInfo u = new UserInfo();
			//根据用户名获取用户数据
			u.setId(tbUserDetail.getId());
			u.setAge(tbUserDetail.getAge());
			u.setPhone(tbUserDetail.getPhone());
			u.setSex(tbUserDetail.getSex());
			u.setSuccess(tbUserDetail.getSuccess());
			u.setUserName(tbUserDetail.getUserName());
			u.setAddDate(tbUserDetail.getAddDate());
			
			TbUser tbuser = new TbUser();
			tbuser.setUserName(tbUserDetail.getUserName());
			tbuser = tbUserService.getUserByUserName(tbuser);
			
			u.setFlag(tbuser.getFlag());
			userinfos.add(u);
		}
		return userinfos;
	}

	
	/**
	 * 根据用户id获取用户信息对象
	 */
	public TbUserDetail getUserDetailByUserNameService(TbUserDetail t){
		return (TbUserDetail) tbUserDetailDao.query("From TbUserDetail where userName like '"+t.getUserName()+"'").get(0);
	}
	
	/**
	 * 更新用户详细信息服务
	 */
	public void updateUserDetailByIdService(TbUserDetail t){
		tbUserDetailDao.update(t);
	}
	
	
	/**
	 * 添加用户详细信息服务
	 */
	
	public void addUserService(TbUserDetail t){
		tbUserDetailDao.insert(t);
	}
	
	/**
	 * 获取用户详细信息最大id
	 */
	public int getMaxIdService(){
		ArrayList<TbUserDetail> list= (ArrayList<TbUserDetail>) tbUserDetailDao.query("From TbUserDetail"); 
		
		int maxId = list.get(list.size()-1).getId();
		maxId++;
		return maxId;
	}
	
	/**
	 * 根据用户名判断用户详细信息是否存在
	 * 存在返回true
	 * 不存在返回false
	 */
	public boolean hasUserDetailService(TbUserDetail t){
		int count = tbUserDetailDao.query("From TbUserDetail where userName like '"+t.getUserName()+"'").size();
		if(count == 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 前提：用户已存在
	 * 根据用户id获取用户详细信息
	 */
	public TbUserDetail getUserDetailByIdService(Integer id){
		return (TbUserDetail) tbUserDetailDao.query("From TbUserDetail where id ="+id).get(0);
	}
	
	/**
	 * 删除用户详细信息
	 */
	public void deleteUserDeatil(TbUserDetail t){
		tbUserDetailDao.delete(t);
	}
}
