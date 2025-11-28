package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Value("${category.board.notice}")
	private String category;
	
	@ModelAttribute("category")
	public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model)throws Exception{
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(BoardDTO boardDTO) throws Exception {
		int result = noticeService.add(boardDTO);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = noticeService.detail(boardDTO);
		model.addAttribute("n", boardDTO);
		
		return "board/detail";
	}
	
	
}
