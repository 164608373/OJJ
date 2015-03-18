package com.sise.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Compileinfo;
import com.sise.service.imp.CompileinfoService;
import com.sise.util.Page;

public class CompileinfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3292567353786390829L;

	private CompileinfoService compileinfoService;
	private String curPage;
	private Page page;
	private String message;
	private List<Compileinfo> lists;

	
	
	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Compileinfo> getLists() {
		return lists;
	}

	public void setLists(List<Compileinfo> lists) {
		this.lists = lists;
	}

	public CompileinfoService getCompileinfoService() {
		return compileinfoService;
	}

	public void setCompileinfoService(CompileinfoService compileinfoService) {
		this.compileinfoService = compileinfoService;
	}
	
	public String pageQuery(){
		//获取当前页数
		 page=new Page();
		
		
		int totalCount = 0;
		//获取有多少条留言
		totalCount = compileinfoService.getMessageCount();
		
		//存好总条数进入page对象中
		page.setTotalCount(totalCount);
		
		if(curPage!=null){
			page.setCurrentPage(Integer.valueOf(curPage));
		}
		
		//分页查询留言板信息
		try {
			lists = compileinfoService.queryPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "pagequeryok";
	}
    
}
