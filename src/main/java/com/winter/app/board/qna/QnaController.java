package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception{
		List<QnaDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "qna/list";
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		return "qna/add";
	}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception{
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("q", qnaDTO);
		
		return "qna/detail";
	}
	
}
