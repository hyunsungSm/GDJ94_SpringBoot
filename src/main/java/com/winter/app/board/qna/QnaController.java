package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@Value("${category.board.qna}")
	private String category;
	
	@ModelAttribute("category")
	public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(BoardDTO boardDTO) throws Exception{
		int result = qnaService.add(boardDTO);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = qnaService.detail(boardDTO);
		model.addAttribute("n", boardDTO);
		
		return "board/detail";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("", qnaDTO);
		
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO) throws Exception {
		
		return "board/add";
	}
	
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
	    qnaService.refUpdate(qnaDTO);

	    qnaDTO = (QnaDTO) qnaService.detail(qnaDTO);
	    model.addAttribute("n", qnaDTO);

	    return "board/update"; 
	}
	
	
}
