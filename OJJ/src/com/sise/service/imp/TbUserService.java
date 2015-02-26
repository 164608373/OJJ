package com.sise.service.imp;

import com.sise.dao.ITbUserDao;
import com.sise.pojo.TbUser;
import com.sise.pojo.TbUserDetail;
import com.sise.service.ITbUserDetailService;
import com.sise.service.ITbUserService;

public class TbUserService implements ITbUserService{
//tb_user服务层实现类
	private ITbUserDao tbUserDao;//tb_user数据持久层实现类

	private ITbUserDetailService tbUserDetailService;//tb_userDetail服务对象
	
	
	
	public void setTbUserDetailService(ITbUserDetailService tbUserDetailService) {
		this.tbUserDetailService = tbUserDetailService;
	}

	public void setTbUserDao(ITbUserDao tbUserDao) {
		this.tbUserDao = tbUserDao;
	}

	/**
	 * 
	 * 用户登陆服务,用户输入密码错误系统将number字段+1,判断是否等于3
	 * 等于3系统就把number更新为0,并将flag更新为1(带表已经上锁)
	 * 返回参数有4个
	 * 0 为登陆成功！     1 为密码错误       2为该用户被锁定请与管理员联系  3为该用户不存在
	 * @return
	 */
	public int loginService(TbUser t){
		//查看该用户是否存在
		boolean hasUser = hasUser(t);
		
		/**
		 * hasUser 
		 * 返回值
		 * true 为用户存在继续执行用户登陆业务
		 * false 为用户不存在返回信息“用户不存在”
		 */
		
		if( !hasUser)
			return 3;
		
		//根据用户名获取用户对象
		TbUser u = (TbUser) tbUserDao.query("From TbUser where userName like '"+t.getUserName()+"'").get(0);
		
		
		if( !t.getPassword().equals(u.getPassword())){
			
			
			if(null == u.getFlag()){
				u.setFlag("0");
			}
			/**
			 * 密码错误时执行的逻辑
			 */
			if(null == u.getNumber()|| u.getNumber().equals("0")){
				u.setNumber("1");
				//更新数据库
				tbUserDao.update(u);
				if(u.getFlag().equals("1")){
					return 2;
				}
				return 1;
				
			}else if(u.getNumber().equals("1")){
				u.setNumber("2");
				//更新数据库
				tbUserDao.update(u);
				if(u.getFlag().equals("1")){
					return 2;
				}
				return 1;
			}else if(u.getNumber().equals("2")){
				u.setNumber("3");
				//更新数据库
				tbUserDao.update(u);
				if(u.getFlag().equals("1")){
					return 2;
				}
				return 1;
			}
			else if(u.getNumber().equals("3")){
				u.setNumber("0");
				u.setFlag("1");
				//更新数据库
				tbUserDao.update(u);
				if(u.getFlag().equals("1")){
					return 2;
				}
				return 1;
			} 
			
			
			return 0;
		}
		//实力一个空的对象存放username作为参数获取对象
		TbUserDetail ubp = new TbUserDetail();
		ubp.setUserName(u.getUserName());
		
		TbUserDetail ub = tbUserDetailService.getUserDetailByUserNameService(ubp); 
		String successStr = ub.getSuccess();
		
		//成功登陆次数
		int success;
		if(successStr == null){
			ub.setSuccess("1");
		}else{
			success = Integer.valueOf(successStr);
			success++;
			ub.setSuccess(String.valueOf(success));
		}
		
		
		//更新用户详细信息数据
		tbUserDetailService.updateUserDetailByIdService(ub);
		
		/**
		 * 密码正确还要判断是否被锁上
		 * 如果tb_user的flag属性等于1则为锁上
		 * 反之为未锁上登陆成功
		 */
		
		if(u.getFlag().equals("1")){
			return 2;
		}
		
		
		//把输入错误次数更新为0
		u.setNumber("0");
		//更新该用户的数据
		tbUserDao.update(u);
		
		return 0;
	}
	
	
	/**
	 * 判断用户是否存在
	 * 存在返回true,反之返回false;
	 * @return
	 */
	public boolean hasUser(TbUser t){
		int count = tbUserDao.query("From TbUser where userName like '"+t.getUserName()+"'").size();
		if(count == 0){
			return false;
		}
		return true;
		
	}

	/**
	 * 根据用户名获取用户对象
	 */
	public TbUser getUserByUserName(TbUser t){
		return (TbUser) tbUserDao.query("From TbUser where userName like '"+t.getUserName()+"'").get(0);
	}
	
	/**
	 * 根据用户id获取用户对象
	 */
	public TbUser getUserById(TbUser t){
		return (TbUser) tbUserDao.query("From TbUser where id ="+t.getId()).get(0);
		
	}
	
	
	/**
	 * 根据用户id进行解锁
	 * @param t
	 */
	public String openLock(TbUser t){
		//根据用户id获取用户对象
		t = getUserById(t);
		//设置锁定状态为0
		t.setFlag("0");
		//更新用户对象
		tbUserDao.update(t);
		
		return "解锁成功！";
	}
	
	
	/**
	 * 添加用户服务
	 */
	
	public void addUserService(TbUser t){
		tbUserDao.insert(t);
	}

	/**
	 * 删除用户服务
	 */
	public void deleteUserService(TbUser t) {
		tbUserDao.delete(t);
	}
	
	/**
	 * 根据用户id获取用户对象
	 */
	public TbUser getUserById(Integer i){
		return (TbUser) tbUserDao.query("From TbUser where id ="+i).get(0);
	}

	/***
	 * 更新用户名
	 */
	public void updateUser(TbUser t) {
		tbUserDao.execute("update from tb_user set userName='"+t.getUserName()+"  where id="+t.getId());
	}
}
