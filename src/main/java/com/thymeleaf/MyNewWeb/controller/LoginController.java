package com.thymeleaf.MyNewWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thymeleaf.MyNewWeb.entity.Account;
import com.thymeleaf.MyNewWeb.service.AccountService;

@Controller
@RequestMapping ("/user")
public class LoginController {
	
	private AccountService theAccountService;
	
	public LoginController (AccountService accountService)
	{
		theAccountService = accountService;
	}
	@GetMapping ("/login")
	public String showMyLoginPage (Model theModel)
	{
		Account theAccount = new Account();
		theModel.addAttribute("account", theAccount);
		
		return "login";
	}
	
	
	@GetMapping ("/loginForm") 
	public String listAccount (@ModelAttribute ("account") Account theAccount)
	{
		String username = theAccount.getUserName();
		String password = theAccount.getPassword();
		boolean userExist = theAccountService.checkLogin(username, password);
		if (userExist)
		{
			return "redirect:/post/list";
		}
		return "login";	
	}
	
	@GetMapping ("/access-denied")
	public String accessDeniedString ()
	{
		return "access-denied";
		
	}

}
