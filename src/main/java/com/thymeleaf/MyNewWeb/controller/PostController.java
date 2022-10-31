package com.thymeleaf.MyNewWeb.controller;
//217410

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thymeleaf.MyNewWeb.entity.Account;
import com.thymeleaf.MyNewWeb.entity.Post;
import com.thymeleaf.MyNewWeb.service.AccountService;
import com.thymeleaf.MyNewWeb.service.PostService;
import com.thymeleaf.MyNewWeb.utils.AccountUtils;
import com.thymeleaf.MyNewWeb.utils.DateUtils;

@Controller
@RequestMapping ("/post")
public class PostController {
	private PostService thePostService;
	@Autowired
	private AccountService theAccountService;
	
	@Autowired
	public PostController (PostService postService)
	{
		thePostService = postService;
	}
	
	
	@GetMapping ("/list")
	public String list (Model theModel)
	{
		List<Post> posts = thePostService.findAll (); 
		theModel.addAttribute("thePost", posts);
		
		return "/post/all-post";
		
	}
	
	@GetMapping ("/myPost")
	public String myPost (Model theModel )
	{
		int userId = AccountUtils.getInstance().getCurrentUserId();
		Account account = theAccountService.findById(userId);
		List <Post> myPosts = account.getPost();
		theModel.addAttribute("myPosts", myPosts);
		return "/post/my-post";
		
	}
	
	@GetMapping ("/read")
	public String getMyPost (@RequestParam ("PostId") int userId, Model theModel)
	{
		Post post = thePostService.getPost(userId);
		theModel.addAttribute("post", post);
		return "/post/read-post";
	}
	
	@GetMapping ("/delete")
	public String deleteById (@RequestParam ("PostId") int id)
	{
		thePostService.deleteById (id);
		return "redirect:/post/myPost";
		
	}
	
	@GetMapping ("/update")
	public String update (@RequestParam ("PostId") int id, Model theModel)
	{
		Post thePost = thePostService.getPost(id);
		theModel.addAttribute("thePost", thePost);
		return "/post/post-form";
	}
	
	@PostMapping ("/save")
	public String savePoString (@ModelAttribute ("thePost") Post thePost)
	{
//		int id = AccountUtils.getInstance().getCurrentUserId();
//		Account account = theAccountService.findById(id);
//		account.add(thePost);
//		theAccountService.update(account);
		thePostService.update(thePost);
		return "redirect:/post/myPost";
		
	}
	
	@GetMapping ("/showFormForAdd")
	public String showForm (Model theModel)
	{
		Post thePost = new Post ();
		theModel.addAttribute("thePost", thePost);
		return "/post/add-form";	
	}
	
	@PostMapping ("/add")
	public String addString (@ModelAttribute ("thePost") Post thePost)
	{
		int id = AccountUtils.getInstance().getCurrentUserId();
		String dateString = DateUtils.getInstance().getDateByFormat("yyyy-MM-dd HH:mm:ss");
		Account account = theAccountService.findById(id);
		thePost.setCreateDate(dateString);
		account.add(thePost);
		theAccountService.add (account);
		return "redirect:/post/myPost";
		
	}
	
}
