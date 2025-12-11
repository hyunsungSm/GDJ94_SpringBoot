package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/users/*")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret:8a0f554d797901598b0fe54f99d25256}")
	private String adminKey;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id:1bdfa64b4ccb8d1c4487b664e9987c09}")
	private String restKey;
	
	@GetMapping("delete")
	public String delete(Authentication authentication)throws Exception{
		// 1. 일반 회원
		
		// 로그아웃 진행
		// 2. 소셜 로그인
		// DB에서 작업
		WebClient webClient = WebClient.create();
		
		Mono<String> result = webClient.post()
		.header("Authorization", "KakaoAK" + adminKey)
		.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
		.body(BodyInserters.fromFormData("target_id_type", "user_id").with("id", authentication.getName()))
		.retrieve()
		.bodyToMono(String.class)
		;
		System.out.println(result.block());
		
		return "./logout";
	}
	
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
