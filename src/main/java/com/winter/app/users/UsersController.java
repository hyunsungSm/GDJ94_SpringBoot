package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/*")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("register")
	public String register()throws Exception{
		return "users/register";
	}
	
	@PostMapping("register")
	public String register(UsersDTO usersDTO, Model model) throws Exception{
		if (usersService.equals(usersDTO.getUsername())) {
			model.addAttribute("error", "이미 사용중인 아이디");
			return "users/register";
		}
		
		usersService.register(usersDTO);
		return "redirect:/";
	}
}
