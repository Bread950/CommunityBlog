package com.thymeleaf.MyNewWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymeleaf.MyNewWeb.entity.Account;
import com.thymeleaf.MyNewWeb.service.AccountService;
import com.thymeleaf.MyNewWeb.utils.AccountUtils;

@Controller
@RequestMapping ("/setting")
public class SettingController {
	private AccountService theAccountService;
	
	@Autowired
	public SettingController (AccountService accountService)
	{
		theAccountService = accountService;
	}
	@GetMapping ("/accountInfo")
	public String getInfo (Model theModel)
	{
		int id = AccountUtils.getInstance().getCurrentUserId();
		Account theAccount = theAccountService.findById(id);
		theModel.addAttribute("theAccount", theAccount);
		return "/setting/display-info";
		
	}
	
	@GetMapping ("/showFormForUpdate")
	public String showUpdateForm (Model theModel)
	{
		int id = AccountUtils.getInstance().getCurrentUserId();
		Account theAccount = theAccountService.findById(id);
		theModel.addAttribute("theAccount", theAccount);
		return "/setting/information-form";
		
	}
	
	@PostMapping ("update")
	public String update (@ModelAttribute ("theAccount") Account theAccount)
	{
		int id = AccountUtils.getInstance().getCurrentUserId();
		theAccountService.update(theAccount, id);
		return "redirect:/setting/accountInfo";
		
	}
	
}
