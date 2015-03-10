package com.sise.service.imp;

import java.util.List;

import com.sise.dao.imp.ProblemDao;
import com.sise.pojo.Problem;
import com.sise.service.IProblemService;
import com.sise.util.Page;

public class ProblemService implements IProblemService{
//problem 服务层实现类
	
	private ProblemDao problemDao;

	public ProblemDao getProblemDao() {
		return problemDao;
	}

	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}
	
	public void addProblem(Problem problem){
		problemDao.insert(problem);
	}
	
	/**
	 * 获取问题的总条数
	 * @return
	 */
	public int getMessageCount(){
		String hql = "From Problem";
		return problemDao.query(hql).size();
	}
	
	/**
	 * 分页查询问题
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Problem> queryPage(Page page) throws Exception{
		String hql = "From Problem ";
		List<Problem> list = null;
	    list =(List<Problem>) problemDao.queryPage(hql, page);
		return list;
	}
	
	/**
	 * 删除问题
	 * @param problem
	 */
	public void deleteProblem(Problem problem){
		problemDao.execute("DELETE FROM problem WHERE problem_id = "+ problem.getProblemId());
	}
	
	/**
	 * 更新问题
	 * @param problem
	 */
	public void updateProblem(Problem problem){
		problemDao.update(problem);
	}
	
	/**
	 * 根据ID查询问题
	 */
	public Problem queryProblem(String id){
		return (Problem) problemDao.query("From Problem p where p.problemId="+id).get(0);
	}
}
