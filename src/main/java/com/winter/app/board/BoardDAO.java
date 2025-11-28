package com.winter.app.board;

import java.util.List;

import com.winter.app.util.Pager;

public interface BoardDAO {

	// 상세
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	// 추가
	public int add(BoardDTO boardDTO)throws Exception;
	
	// 삭제
	public int delete(BoardDTO boardDTO) throws Exception;
	
	// 업데이트
	public int update(BoardDTO boardDTO) throws Exception;
	
	// 리스트
	public List<BoardDTO> list(Pager pager)throws Exception;
	
	public Long count(Pager pager)throws Exception;
}
