package com.winter.app.config.security;

import com.winter.app.users.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Lazy
	@Autowired
    private final UserDetailServiceImpl userDetailServiceImpl;

    SecurityConfig(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

	// 정적 자원들을 Security에서 제외
	@Bean
	WebSecurityCustomizer customizer() {
		
		return web -> {
			web
				.ignoring()
					.requestMatchers("/css/**")
					.requestMatchers("/images/**", "/img/**")
					.requestMatchers("/js/**", "/vendor/**")
					;
		};
	}
	
	// 인증과 인가에 관한 설정
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		
		security
			.cors((cors)->{cors.disable();})
			.csrf((csrf)->{csrf.disable();})
			
			// 인가(권한)에 관한 설정
			.authorizeHttpRequests((auth)->{
				auth
					.requestMatchers("/notice/add", "/notice/update", "/notice/delete").hasRole("ADMIN")
					.requestMatchers("/product/add", "/product/update", "/product/delete").hasAnyRole("MANAGER", "ADMIN")
					.requestMatchers("/product/**").authenticated()
					.requestMatchers("/users/mypage", "/users/update", "/users/logout").authenticated()
					.anyRequest().permitAll();
			})
			
			// Login form 관련 설정 
			.formLogin((form)->{
				form
					.loginPage("/users/login")
//					.usernameParameter("id")
//					.passwordParameter("pw")
					.defaultSuccessUrl("/", true)
//					.failureUrl("/")
					;
			})
			
			.logout((logout)->{
				logout
					.logoutUrl("/users/logout")
//					.logoutSuccessUrl("/")
//					.logoutSuccessHandler()
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					;
			})
//			.rememberMe((rememberMe)->{
//				
//			})
			
			.sessionManagement(session -> {
				session
						.invalidSessionUrl("/")
						.maximumSessions(1)
						.maxSessionsPreventsLogin(true)
						.expiredUrl("/users/login")
						;
			})
			.oauth2Login(t->{
				t.userInfoEndpoint((s)->{
					s.userService(userDetailServiceImpl);
				});
			})
			
			
			;
		
		return security.build();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
