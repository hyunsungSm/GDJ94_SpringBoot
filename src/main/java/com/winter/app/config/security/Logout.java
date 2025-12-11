package com.winter.app.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Mono;

public class Logout implements LogoutHandler{

	@Value("${spring.security.oauth2.client.registration.kakao.client-secret:8a0f554d797901598b0fe54f99d25256}")
	private String adminKey;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id:1bdfa64b4ccb8d1c4487b664e9987c09}")
	private String restKey;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if(authentication == null) {
			return;
		}
		// kakao 서버로 로그아웃 요청을 보내자
//		WebClient webClient = WebClient.create();
//		
//		Mono<Long> result = webClient
//		.post()
//		.uri("https://kapi.kakao.com/v1/user/me")
//		.header("Authorization", "KakaoAK" + adminKey)
//		.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
//		.body(BodyInserters.fromFormData("target_id_type", "user_id").with("id", authentication.getName()))
//		.retrieve()
//		.bodyToMono(Long.class)
//		;
//		System.out.println(result.block());
		// 카카오 계정과 함께 로그아웃
		try {
			response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=" + restKey + "&logout_redirect_uri=http://localhost");
		} catch (IOException e) {
			System.out.println("test");
			e.printStackTrace();
		}
	}

	
}
