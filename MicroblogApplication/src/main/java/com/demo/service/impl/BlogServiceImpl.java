package com.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Blog;
import com.demo.payloads.BlogDto;
import com.demo.repository.BlogRepo;
import com.demo.service.BlogService;
import com.demo.exception.*;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepo blogRepo;

	@Override
	public BlogDto createUser(BlogDto blogDto) {
		
		Blog blog=this.dtoToUser(blogDto);
		
		Blog savedUser=this.blogRepo.save(blog);
		
		return this.userToDto(savedUser);
	}

	@Override
	public BlogDto updateUser(BlogDto blogDto, Integer userId) {
		
		Blog blog=this.blogRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));		
		
		blog.setTitle(blogDto.getTitle());
		blog.setDiscription(blogDto.getDiscription());
		blog.setCreationDate(blogDto.getCreationDate());
		
		Blog updateUser=this.blogRepo.save(blog);
		BlogDto userDto1=this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public BlogDto getUserById(Integer userId) {
		Blog blog=this.blogRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));		

		
		return this.userToDto(blog);
	}

	@Override
	public List<BlogDto> getAllUser() {
		List<Blog> blogs=  this.blogRepo.findAll();	
		List<BlogDto> blogDtos= blogs.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
			
		return blogDtos;
	}

	
	@Override
	public void deleteUser(Integer userId) {
		Blog blog=this.blogRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));		
       
		this.blogRepo.delete(blog);
		
	}
	
	public Blog dtoToUser(BlogDto blogDto) {
		Blog blog =new Blog();
		
		blog.setId(blogDto.getId());
		blog.setTitle(blogDto.getTitle());
		blog.setDiscription(blogDto.getDiscription());
		blog.setCreationDate(blogDto.getCreationDate());
		
		
		return blog;
	}
	
	public BlogDto userToDto(Blog blog) {
		BlogDto blogDto=new BlogDto();
		
		blogDto.setId(blog.getId());
		blogDto.setTitle(blog.getTitle());
		blogDto.setDiscription(blog.getDiscription());
		blogDto.setCreationDate(blog.getCreationDate());
		
		return blogDto;
		
	}

}
