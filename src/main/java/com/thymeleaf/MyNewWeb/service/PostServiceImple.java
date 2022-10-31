package com.thymeleaf.MyNewWeb.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleaf.MyNewWeb.dao.AccountRepository;
import com.thymeleaf.MyNewWeb.dao.PostRepository;
import com.thymeleaf.MyNewWeb.entity.Account;
import com.thymeleaf.MyNewWeb.entity.Post;

@Service
public class PostServiceImple implements PostService 
{

	private PostRepository thePostRepository;
	
	@Autowired
	public PostServiceImple (PostRepository PostRepository)
	{
		thePostRepository = PostRepository;
	}
	@Override
	public List<Post> findAll() {
	
	return thePostRepository.findAll();

	}
	
	@Override
	public Post getPost(int userId) {
		Optional<Post> result = thePostRepository.findById(userId);
		Post post = null;
		if (result.isPresent())
		{
			post = result.get();
		}
		return post;
	}
	@Override
	public void deleteById(int id) {
		thePostRepository.deleteById(id);
	}
	@Override
	public void update(Post thePost) {
		String title = thePost.getTitle();
		int id = thePost.getId();
		String content = thePost.getContent();
		thePostRepository.update (title, content, id);
		
	}
}