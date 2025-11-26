package com.winter.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.board.notice.NoticeDTO;

@SpringBootTest
class QnaDAOTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	void insert()throws Exception{
		for (int i = 0; i < 200; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setBoardTitle("title"+1);
			qnaDTO.setBoardWriter("writer"+1);
			qnaDTO.setBoardContents("contents"+1);
			qnaDAO.add(qnaDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
	}
	
//	@Test
	void testAdd()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setBoardTitle("무탑못미는");
		qnaDTO.setBoardWriter("이태민");
		qnaDTO.setBoardContents("실화냐");
		int result = qnaDAO.add(qnaDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
	void test() {
		fail("Not yet implemented");
	}

}
