package com.winter.app.ajax;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.nimbusds.jose.shaded.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AjaxTest1 {

	public void t3() throws Exception{
		RestTemplate res = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Content-type", "application/json; charset=UTF-8");
		
//		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//		params.add("title", "title");
//		params.add("body", "body");
//		params.add("userId", "5");
		
		PostDTO postDTO = new PostDTO();
		postDTO.setTitle("title");
		postDTO.setBody("body");
		postDTO.setUserId(5);
		
		HttpEntity<PostDTO> req = new HttpEntity<PostDTO>(postDTO, headers);
		
		postDTO = res.postForObject("https://jsonplaceholder.typicode.com/posts", req, PostDTO.class);
		log.info("{}", postDTO);
	}
	
	public void t2()throws Exception{
		RestTemplate res = new RestTemplate();
		
		List<PostDTO> postDTO = res.getForObject("https://jsonplaceholder.typicode.com/posts/", List.class);
		
		log.info("{}", postDTO.get(5));
	}
	
	public void t1() throws Exception{
		// 1. RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		// 2. Header 설정
		
		// 3. parameter 설정
		
		ResponseEntity<PostDTO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", PostDTO.class);
		PostDTO postDTO = res.getBody();
		
//		PostDTO postDTO = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/2", PostDTO.class);
		
		log.info("{}", postDTO);
	}
}
