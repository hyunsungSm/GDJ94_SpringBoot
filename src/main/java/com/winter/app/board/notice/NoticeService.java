package com.winter.app.board.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
    @Override
	public Long count(Pager pager) throws Exception {
		return null;
	}

	public List<BoardDTO> list(Pager pager) throws Exception {
    	// 1. totalCount 구하기
    	Long totalCount = noticeDAO.count(pager);
    	pager.pageing(totalCount);
    	
    	
    	return noticeDAO.list(pager);
    }	
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.detail(boardDTO);
	}
	
	public int add(BoardDTO boardDTO)throws Exception {
		return noticeDAO.add(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO)throws Exception{
		return noticeDAO.delete(boardDTO);
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		return noticeDAO.update(boardDTO);
	}
	
}
