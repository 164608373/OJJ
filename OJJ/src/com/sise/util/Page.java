package com.sise.util;

public class Page {
	private int totalCount;//总条数
	private int pageCount=5;//一页多少条
	private int totalPage;//总页数
	private int currentPage=1;//当前页
	private int start;//开始取数据
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//计算总页数
		double d = (this.totalCount+0.0)/this.pageCount;
		this.totalPage = (int)Math.ceil(d);
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStart() {
		//计算数据库取数据的开始位置
		if(currentPage <=0){
			currentPage=1;
		}else if(currentPage > totalPage){
			currentPage = totalPage;
		}
		start = (currentPage-1)*pageCount;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
