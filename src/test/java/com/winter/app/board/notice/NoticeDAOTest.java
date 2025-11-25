package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void testDetail() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		
		assertNotNull(noticeDTO);
	}
	
//	@Test
	void testAdd()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardTitle("무탑못미는");
		noticeDTO.setBoardWriter("이태민");
		noticeDTO.setBoardContents("실화냐");
		int result = noticeDAO.add(noticeDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
	void testDelete() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(2L);
		int result = noticeDAO.delete(noticeDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
	void testUpdate() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("title", "title");
		map.put("writer", "나");
		map.put("contents", "contents");
		map.put("num", 1L);
		int result = noticeDAO.update(map);
		
		assertEquals(1, result);
	}
	
	@Test
	void testList()throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	void test() {
		fail("Not yet implemented");
	}

}
