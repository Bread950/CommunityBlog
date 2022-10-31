package com.thymeleaf.MyNewWeb.utils;

public class AccountUtils {

	private static AccountUtils accUtils;
	
	private int currentUserId = 0;
	
	private AccountUtils() {
	}
	
	public static AccountUtils getInstance() {
	  if(accUtils == null) {
		  accUtils = new AccountUtils();
	  }
	  return accUtils;
	}

	public int getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(int currentUserId) {
		this.currentUserId = currentUserId;
	}
	
	
}
