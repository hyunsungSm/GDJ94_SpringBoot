package com.winter.app.board.qna;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	
	// list
	public List<BoardDTO> list(Pager pager) throws Exception{
		Long totalCount = qnaDAO.count(pager);
		pager.pageing(totalCount);
		
		return qnaDAO.list(pager);
	}
	
	// add
	public int add(BoardDTO boardDTO) throws Exception{
		return qnaDAO.add(boardDTO);
	}
	
	// detail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception{
		return qnaDAO.detail(boardDTO);
	}
	
	// update
	public int update(BoardDTO boardDTO) throws Exception{
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public Long count(Pager pager) throws Exception {
		return null;
	}
	
	public int refUpdate(QnaDTO qnaDTO) throws Exception {
	    return qnaDAO.refUpdate(qnaDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		// 1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO) qnaDAO.detail(qnaDTO);
		
		// 2. 부모의 정보를 이용해서 step을 업데이트
		int result = qnaDAO.stepUpdate(parent);
		
		// 3. 부모의 정보를 이용해서 ref, step, depth를 세팅
		qnaDTO.setBoardRef(parent.getBoardRef());
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		qnaDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		// 4. insert
		result = qnaDAO.add(qnaDTO);
		
		return result;
		
	}
	
	@Override
	public BoardFileDTO fileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.fileDetail(boardFileDTO);
	}
}
