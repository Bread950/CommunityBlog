package com.thymeleaf.MyNewWeb.service;

import java.util.List;

import com.thymeleaf.MyNewWeb.entity.Post;



public interface PostService {

	List<Post> findAll();
//	public List <Account> getAccounts ();
//	public List <Post> findAll ();
//	public void save(Post thePost, int id);
//	public List<Post> getMyPost(int userID);
//	public List<Post> getInfoMyPost(int id);
//	public void deleteById(int id);
// public Post findById(int id);
//	

	Post getPost(int userId);

	void deleteById(int id);

	void update(Post thePost);
}
