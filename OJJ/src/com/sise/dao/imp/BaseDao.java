package com.sise.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sise.dao.IBaseDao;
import com.sise.util.Page;
@SuppressWarnings("unchecked")
public abstract class BaseDao implements IBaseDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	/**
	 * 删除
	 * @param o
	 */
	public void delete(Object o){
		hibernateTemplate.delete(o);
	}
	/**
	 * 增加
	 * @param o
	 */
	public void insert(Object o){
		hibernateTemplate.save(o);
	}
	/**
	 * 修改
	 * @param o
	 */
	public void update(Object o){
		hibernateTemplate.update(o);
	}
	
	/**
	 * 全部查询 没有排序
	 * @param o
	 * @return
	 */
	public List queryAll(Object o){
		String hql = "from "+o.getClass().getSimpleName();
		return hibernateTemplate.find(hql);
	}
	
	/**
	 * 其他查询
	 */
	public List query(String hql){
		return hibernateTemplate.find(hql);
	};
	/**
	 * 执行原生的修改，增加和删除语句
	 */
	public void execute(final String sql){
		try {
			hibernateTemplate.execute(new HibernateCallback() {
				
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					session.beginTransaction();
					Query query = session.createSQLQuery(sql);
					query.executeUpdate();
					session.getTransaction().commit();
					session.close();
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 按条件执行hql语句
	 */
	public List queryByObject(String hql, Object[] values) {
		return  hibernateTemplate.find(hql, values);
	}
	
	
	/**
	 * hql分页查询
	 */
	public List queryPage(final String hql, Page page) throws Exception {
		

		
		// 拿到总条数后就要对当前页进行判断
				if (page.getCurrentPage() <= 0)
					page.setCurrentPage(1);
				if (page.getCurrentPage() >= page.getTotalPage())
					page.setCurrentPage(page.getTotalPage());

				final Integer offset = (page.getCurrentPage() - 1)
						* page.getPageCount(); // 要知道是从零开始的
				final Integer length = page.getPageCount();
				
			final int firstResult = offset;
			final int maxResults = length;
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery( hql );
				query.setFirstResult( firstResult );
				query.setMaxResults( maxResults );
				List list = query.list();
				return list;
			}
		});
		return list;
	}

}
