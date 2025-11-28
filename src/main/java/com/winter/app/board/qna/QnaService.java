package com.winter.app.board.qna;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Service
public class QnaService {

	@Autowired
	private QnaDAO qnaDAO;
	
	// list
	public List<QnaDTO> list(Pager pager) throws Exception{
		Long totalCount = qnaDAO.count(pager);
		pager.pageing(totalCount);
		
		return qnaDAO.list(pager);
	}
	
	// add
	public int add(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.add(qnaDTO);
	}
	
	// detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.detail(qnaDTO);
	}
	
	// update
	public int update(Map<String, Object> map) throws Exception{
		return qnaDAO.update(map);
	}
}
