package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Blog;

public interface BlogRepo extends JpaRepository<Blog,Integer> {

}
