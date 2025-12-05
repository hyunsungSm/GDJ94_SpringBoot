package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users/*")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("register")
	public String register(Model model) throws Exception {
	    model.addAttribute("usersDTO", new UsersDTO());
	    return "users/register";
	}

	
	@PostMapping("register")
	public String register(@ModelAttribute("usersDTO") UsersDTO usersDTO, BindingResult bindingResult) throws Exception{
		if (usersService.getError(usersDTO, bindingResult)) {
			return "users/register";
		}
		
//		int result = usersService.register(usersDTO);
		
		usersService.register(usersDTO);
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public void detail (UsersDTO usersDTO, Model model) throws Exception {
		usersDTO = usersService.detail(usersDTO);
		model.addAttribute("user", model);
	}
	
	@GetMapping("login")
	public void login() throws Exception{
		
	}
	@PostMapping("login")
	public String login(UsersDTO usersDTO, HttpSession session) throws Exception{
		usersDTO = usersService.detail(usersDTO);
		
		session.setAttribute("user", usersDTO);
		
		return "redirect:/";
	}
	
	@GetMapping("update")
	public void update(HttpSession session, Model model) throws Exception{
		model.addAttribute("userDTO", session.getAttribute("user"));
	}
	
	@PostMapping("update")
	public String update(@Validated(RegisterGroup.class) UsersDTO usersDTO, BindingResult bindingResult) throws Exception{
		if (bindingResult.hasErrors()) {
			return "users/update";
		}
		
		return "redirect:./mypage";
	}
	
	
}
