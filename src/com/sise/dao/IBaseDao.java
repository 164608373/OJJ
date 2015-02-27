package com.sise.dao;

import java.util.List;

import com.sise.util.Page;

public  interface IBaseDao {

	/**
	 * 增加
	 * @param o
	 */
	public void insert(Object o);
	/**
	 * 修改
	 * @param o
	 */
	public void update(Object o);
	/**
	 * 删除
	 * @param o
	 */
	public void delete(Object o);

	
	/**
	 * 全部查询
	 * @param o
	 * @return
	 */
	public List queryAll(Object o);
	/**
	 * 执行查询语句
	 * @param hql
	 * @return
	 */
	public List query(String hql);
	/**
	 * 执行原生的sql语句
	 * @param sql
	 */
	public void execute(String sql);
	
	/**
	 * 按条件执行hql语句
	 * @param sql
	 * @param values
	 * @return
	 */
	public List queryByObject(String hql, Object[] values);
	
	
	/**
	 * hql分页查询
	 * @param hql
	 * @param startIndex  从第几条数据开始
	 * @param pageSize	每页条数
	 * @return
	 */
	public List queryPage(final String hql, Page page)throws Exception;
	
}
