package com.demo.service;

import java.util.List;

import com.demo.payloads.BlogDto;

public interface BlogService {
	
	
	BlogDto createUser(BlogDto user);
	
	BlogDto updateUser(BlogDto user,Integer userId);
	
	BlogDto getUserById(Integer userId);
	
	List<BlogDto> getAllUser();
	
	void deleteUser(Integer userId);
}