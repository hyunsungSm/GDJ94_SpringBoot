package com.winter.app.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Mapper
public interface QnaDAO {

	// list
	public List<QnaDTO> list(Pager pager) throws Exception;
	
	// 추가
	public int add(QnaDTO qnaDTO) throws Exception;
	
	// 상세
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception;
	
	// 업데이트
	public int update(Map<String, Object> map) throws Exception;
	
	public Long count(Pager pager)throws Exception;
}
