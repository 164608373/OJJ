package com.sise.service.imp;

import com.sise.dao.IUsersDao;
import com.sise.pojo.TbUser;
import com.sise.pojo.Users;
import com.sise.service.IUsersService;

public class UsersService implements IUsersService {

	private IUsersDao usersDao;//tb_user数据持久层实现类

	public IUsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(IUsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	
	
	/**
	 * 判断用户是否存在
	 * 存在返回true,反之返回false;
	 * @return
	 */
	public boolean hasUser(Users t){
		int count = usersDao.query("From Users where user_id like '"+t.getUserId()+"'").size();
		if(count == 0){
			return false;
		}
		return true;
		
	}
	
	/**
	 * 根据用户名id获取用户对象
	 */
	public TbUser getUserByUserId(Users t){
		return (TbUser) usersDao.query("From Users where user_id like '"+t.getUserId()+"'").get(0);
	}
	
	/**
	 * 根据用户id和密码获取用户对象
	 * 
	 */
	public boolean loginUser(Users t){
		int count = usersDao.query("From Users where user_id like '"+t.getUserId()+"' and password like '"+t.getPassword()+"'").size();
		if(count == 0){
			return false;
		}
		return true;
	}
	
	
	/**
	 * 注册用户
	 * 
	 */
	public void register(Users t){
		usersDao.insert(t);
	}
	
	/**
	 * 更新用户信息
	 * 
	 */
	public void update(Users t){
		usersDao.update(t);
	}
}
