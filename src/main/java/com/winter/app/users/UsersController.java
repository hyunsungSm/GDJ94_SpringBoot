package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public void detail (@AuthenticationPrincipal UsersDTO usersDTO, Model model) throws Exception {
		usersDTO = usersService.detail(usersDTO);
		model.addAttribute("user", model);
	}
	
	@GetMapping("login")
	public void login() throws Exception{
		
	}
	
	@GetMapping("update")
	public void update(HttpSession session, Model model) throws Exception{
		model.addAttribute("userDTO", session.getAttribute("user"));
	}
	
	@PostMapping("update")
	public String update(@Validated(RegisterGroup.class) UsersDTO usersDTO, BindingResult bindingResult, Authentication authentication) throws Exception{
		if (bindingResult.hasErrors()) {
			return "users/update";
		}
		
		usersDTO.setUsername(authentication.getName());
		
		int result = usersService.update(usersDTO);
		
		if (result > 0) {
			UsernamePasswordAuthenticationToken to = new UsernamePasswordAuthenticationToken(bindingResult, authentication.getCredentials(), authentication.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(to);
		}
		
		return "redirect:/";
	}
	
	
}
