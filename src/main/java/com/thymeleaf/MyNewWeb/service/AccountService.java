package com.thymeleaf.MyNewWeb.service;

import com.thymeleaf.MyNewWeb.entity.Account;

public interface AccountService {
	public boolean  checkLogin (String userName, String password);

	public Account findById(int userId);

	public void add(Account account);

	public void update(Account theAccount, int id);
}
