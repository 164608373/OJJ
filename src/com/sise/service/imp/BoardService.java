package com.sise.service.imp;

import java.util.List;

import com.sise.dao.imp.BoardDao;
import com.sise.pojo.Board;
import com.sise.service.IBoardService;
import com.sise.util.Page;

public class BoardService implements IBoardService {
//留言板服务层实现类
	
	private BoardDao boardDao;

	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	} 
	
	/**
	 * 分页查询留言板信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Board> queryPage(Page page) throws Exception{
		String hql = "From Board ";
		List<Board> list = null;
	    list =(List<Board>) boardDao.queryPage(hql, page);
		
		return list;
	}
	
	/**
	 * 获取留言板信息的总条数
	 * @param board
	 */
	public int getMessageCount(){
		String hql = "From Board";
		return boardDao.query(hql).size();
	}
	
	public void postMessage(Board board){
		boardDao.insert(board);
	}
}
