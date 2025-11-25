package com.winter.app.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BoardDAOTest {

	@Autowired
	private BoardDAO boardDAO;
	
//	@Test
	void testAdd()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("t1");
		boardDTO.setWriter("w1");
		boardDTO.setContents("c1");
		int result = boardDAO.add(boardDTO);
		assertEquals(1, result);	
	}
	
//	@Test
	void testDelete()throws Exception {
		int result = boardDAO.delete(58L);
		assertEquals(1, result);
	}
	
//	@Test
	void testList()throws Exception {
		List<BoardDTO> ar = boardDAO.list();
		log.info("{}", ar.getClass());
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	void testDetail() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(36L);
		boardDTO = boardDAO.detail(boardDTO);
//		log.info(boardDTO.toString());
		
		assertNotNull(boardDTO);
	}
	
//	@Test
	void testUpdate()throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("t", "update T");
		map.put("c", "update C");
		map.put("n", 36L);
		int result = boardDAO.update(map);
		
		assertEquals(1, result);
	}

}
