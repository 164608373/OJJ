package com.sise.service.imp;

import java.util.List;

import com.sise.dao.imp.CompileinfoDao;
import com.sise.pojo.Compileinfo;
import com.sise.pojo.Problem;
import com.sise.service.ICompileinfoService;
import com.sise.util.Page;

public class CompileinfoService implements ICompileinfoService {
//编译信息服务层实现类
	private CompileinfoDao compileinfoDao;

	public CompileinfoDao getCompileinfoDao() {
		return compileinfoDao;
	}

	public void setCompileinfoDao(CompileinfoDao compileinfoDao) {
		this.compileinfoDao = compileinfoDao;
	}
	
	/**
	 * 加入编译信息
	 */
	public void addComp(Compileinfo compileinfo){
		compileinfoDao.insert(compileinfo);
	}
	
	/**
	 * 分页查询编译信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Compileinfo> queryPage(Page page) throws Exception{
		String hql = "From Compileinfo ";
		List<Compileinfo> list = null;
	    list =(List<Compileinfo>) compileinfoDao.queryPage(hql, page);
		return list;
	}
	
	/**
	 * 获取编译信息的总条数
	 * @return
	 */
	public int getMessageCount(){
		String hql = "From Compileinfo";
		return compileinfoDao.query(hql).size();
	}
	
}
