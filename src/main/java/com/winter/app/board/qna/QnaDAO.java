package com.winter.app.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Mapper
public interface QnaDAO extends BoardDAO {

	public int refUpdate(QnaDTO qnaDTO)throws Exception;
	
	public int stepUpdate(BoardDTO boardDTO)throws Exception;
}
