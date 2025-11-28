package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model)throws Exception{
		List<NoticeDTO> ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "notice/list";
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		return "notice/add";
	}
	
	@PostMapping("add")
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception{
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("n", noticeDTO);
		
		return "notice/detail";
	}
	
	
}
