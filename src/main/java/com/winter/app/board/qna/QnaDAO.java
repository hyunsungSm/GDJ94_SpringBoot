package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.util.Pager;

@Mapper
public interface QnaDAO {

	// list
	public List<QnaDTO> list(Pager pager) throws Exception;
	
	// 추가
	public int add(QnaDTO qnaDTO) throws Exception;
	
	public Long count()throws Exception;
}
