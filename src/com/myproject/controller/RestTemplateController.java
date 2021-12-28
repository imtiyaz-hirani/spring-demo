package com.myproject.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myproject.model.Post;

@RestController
public class RestTemplateController {

	private final static String GET_POST_API="https://jsonplaceholder.typicode.com/posts?_limit=10";
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/posts", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post[]> fetchExternalApi() {
		//call the external API 
		//and return the response 
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Post> entity = new HttpEntity<Post>(headers);
		 
		RestTemplate restTemplate = new RestTemplate(); 
		ResponseEntity<Post[]> resp = restTemplate.exchange(GET_POST_API, 
				HttpMethod.GET, entity, Post[].class);
		
		return resp; 
		 
	}
}
