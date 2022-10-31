package com.thymeleaf.MyNewWeb.service;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleaf.MyNewWeb.dao.AccountRepository;
import com.thymeleaf.MyNewWeb.entity.Account;
import com.thymeleaf.MyNewWeb.utils.AccountUtils;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl (AccountRepository theAccountRepository)
	{
		accountRepository = theAccountRepository;
	}
	@Override
	public boolean checkLogin(String userName, String password) {
		List <Account> accounts = accountRepository.findAll();
		boolean user = false;
		for (int i = 0; i<accounts.size(); i++)
		{
			if (userName.compareTo(accounts.get(i).getUserName())==0 && password.compareTo(accounts.get(i).getPassword())==0)
			{
				user = true;
				AccountUtils.getInstance().setCurrentUserId(accounts.get(i).getId());	
				System.out.println(accounts.get(i).getId());
			}
		}
		
		return user;
	}
	@Override
	public Account findById(int userId) {
		Account account = accountRepository.findByUserId(userId);
		return account;
	}
	
	@Override
	public void add(Account account) {
		accountRepository.save(account);
		
	}
	@Override
	public void update(Account theAccount, int id) {
		String phoneNumber = theAccount.getPhoneNumber();
		String email = theAccount.getEmail();
		int gender = theAccount.getGender();
		String displayName = theAccount.getDisplayName();
		accountRepository.update(phoneNumber,email, gender, displayName, id);
		
	}
	
	

}
