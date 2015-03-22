package com.sise.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Board;
import com.sise.pojo.Users;
import com.sise.service.imp.BoardService;
import com.sise.util.Page;
import com.sise.util.UTF2GBK;
import com.sise.util.Util;

public class BoardAction extends ActionSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = -5422906075978185765L;
//留言板控制层对象
	private BoardService boardService;
	private List<Board> boardlist;
	private String curPage;
	private Page page;
	private String message;
	
	
	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	
	public List<Board> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(List<Board> boardlist) {
		this.boardlist = boardlist;
	}

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

	/**
	 * 分页查询留言
	 */
	public String queryPage(){
		//获取当前页数
		page=new Page();
				
				int totalCount = 0;
				//获取有多少条留言
				totalCount = boardService.getMessageCount();
				
				//存好总条数进入page对象中
				page.setTotalCount(totalCount);
				
				if(curPage!=null){
					page.setCurrentPage(Integer.valueOf(curPage));
				}
				
				//分页查询留言板信息
				try {
					boardlist = boardService.queryPage(page);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return "queryMessageSucced";
	}
	
	/**
	 * 发表留言
	 */
	public String postmessage(){
		
		//实例一个空的对象
		Board board = new Board();
		
		try {
			//处理乱码转码
			message = new String(message.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//从session中获取登陆用户信息
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Users user = (Users)session.get("user");
		
		//先检查是否登陆
		if(null == user){
			return "postFail";
		}
		
		//发布时间
		Timestamp postTime = new Timestamp(System.currentTimeMillis()); 
		//发布人id
		String user_id  = user.getUserId();
		
		board.setMessage(message);
		board.setPosttime(postTime);
		board.setUserId(user_id);
		
		//保存信息
		boardService.postMessage(board);
		
		return "postSuccess";
	}
	
	
	
	
}
