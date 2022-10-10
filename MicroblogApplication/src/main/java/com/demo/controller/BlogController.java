package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.payloads.ApiResponse;
import com.demo.payloads.BlogDto;
import com.demo.service.BlogService;

@RestController
@RequestMapping("/users")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
//post- create 
//http://localhost:8080/users/
	
	@PostMapping("/")
	public ResponseEntity<BlogDto> createUser(@RequestBody BlogDto blogDto){
		BlogDto createUserDto=this.blogService.createUser(blogDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
//PUT mapping for update records
//http://localhost:8080/users/?	
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<BlogDto> updateUser(@RequestBody BlogDto blogDto,@PathVariable()Integer userId){
	BlogDto updateUser= this.blogService.updateUser(blogDto, userId);
	return  ResponseEntity.ok(updateUser);
	}
	
	
//DELETE mapping for delete records
//http://localhost:8080/users/?
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable() Integer userId){
	this.blogService.deleteUser(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("delete successfully",true),HttpStatus.OK);
		
	}
	
//GET for fetching data  http://localhost:8080/users/
	
	@GetMapping("/")
	public ResponseEntity<List<BlogDto>> getAllUsers(){
		return ResponseEntity.ok(this.blogService.getAllUser());
	}
	
	
//GET by id http://localhost:8080/users/?
	
	@GetMapping("/{userId}")
	public ResponseEntity<BlogDto>getSingleUsers(@PathVariable Integer userId){
		return ResponseEntity.ok(this.blogService.getUserById(userId));
	}
	

}
