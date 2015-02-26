package com.sise.service.imp;

import com.sise.dao.imp.ProblemDao;
import com.sise.service.IProblemService;

public class ProblemService implements IProblemService{
//problem 服务层实现类
	
	private ProblemDao problemDao;

	public ProblemDao getProblemDao() {
		return problemDao;
	}

	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}
	
	
}
