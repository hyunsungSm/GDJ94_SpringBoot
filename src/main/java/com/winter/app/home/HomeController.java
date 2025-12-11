package com.winter.app.home;

import java.security.Principal;
import java.util.Enumeration;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.winter.app.users.UsersDTO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/")
	public String index5(Authentication authentication, Model model) throws Exception {

	    UsersDTO usersDTO = null;

	    // 로그인 상태인지 체크
	    if (authentication != null
	            && authentication.isAuthenticated()
	            && !(authentication instanceof AnonymousAuthenticationToken)) {

	        // principal에서 꺼내기 (UsersDTO가 UserDetails 구현했다고 가정)
	        usersDTO = (UsersDTO) authentication.getPrincipal();

	        System.out.println("username : " + usersDTO.getUsername());
	        System.out.println("auth name: " + authentication.getName());

	        model.addAttribute("user", usersDTO);
	        model.addAttribute("isLogin", true);
	    } else {
	        System.out.println("비로그인 사용자");
	        model.addAttribute("isLogin", false);
	    }

	    return "index";
	}
//	@GetMapping("/")
//	public String index4(Principal principal) throws Exception{
//		UsersDTO usersDTO = (UsersDTO) principal;
//		System.out.println(usersDTO.getUsername());
//		return "index";
//	}
	
//	@GetMapping("/")
//	public String index3(Authentication authentication) throws Exception{
//		UsersDTO usersDTO = (UsersDTO) authentication.getPrincipal();
//		System.out.println(usersDTO.getUsername());
//		System.out.println(authentication.getName());
//		return "index";
//	}
	
//	@GetMapping("/")
//	public String index2() throws Exception{
//		Object obj = SecurityContextHolder.getContext().getAuthentication();
//		
//		Authentication authentication = (Authentication) obj;
//		
//		UsersDTO usersDTO = (UsersDTO) authentication.getPrincipal();
//		
//		System.out.println(usersDTO.getUsername());
//		System.out.println(authentication.getName());
//		
//		return "index";
//	}
//	
	
//	@GetMapping("/")
//	public String index(HttpSession session)throws Exception{
//		SecurityContextImpl obj = (SecurityContextImpl) session.getAttribute("");
//		Authentication authentication = obj.getAuthentication();
//		log.info("{}", authentication);
//		UsersDTO usersDTO = (UsersDTO) authentication;
//		System.out.println(usersDTO.getUsername());
//		System.out.println(obj);
//		
//		Enumeration<String> en = session.getAttributeNames();
//		
//		while(en.hasMoreElements()) {
//			String k = en.nextElement();
//			System.out.println(k);
//		}
//		
//		return "index";
//	}
}
