package com.winter.app.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailServiceImpl extends DefaultOAuth2UserService implements UserDetailsService{

	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("{}", userRequest);
		
		return super.loadUser(userRequest);
	}	



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인 요청");
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsername(username);
		UserDetails userDetails;
		try {
			userDetails = usersDAO.detail(usersDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username);
		}
		return userDetails;
	}

	
	private void useKakao(OAuth2UserRequest auth2UserRequest) throws Exception{
		OAuth2User user = super.loadUser(auth2UserRequest);
		log.info("name: {}", user.getName());
		log.info("attr: {}", user.getAttributes());
		log.info("auth: {}", user.getAuthorities());
		Map<String, Object> attr = user.getAttribute("properties");
		
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsername(user.getName());
		
		try {
			usersDTO = usersDAO.detail(usersDTO);
			if(usersDTO == null) {
				usersDTO.setUsername(user.getName());
				usersDTO.setPassword("kakao");
				usersDTO.setName(attr.get("nickname").toString());
				usersDAO.register(usersDTO);
				UsersFileDTO usersFileDTO = new UsersFileDTO();
				usersFileDTO.setFileName(attr.get("profile_image").toString());
				usersFileDTO.setUserName(user.getName());
				usersDAO.userFileAdd(usersFileDTO);
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
