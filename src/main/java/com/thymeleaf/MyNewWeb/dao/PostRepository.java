package com.thymeleaf.MyNewWeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.thymeleaf.MyNewWeb.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query ("Update Post p set p.content = :content, p.title = :title  where p.id = :id")
	void update(@Param ("title") String title, @Param ("content") String content, @Param ("id") int id);
	
}
