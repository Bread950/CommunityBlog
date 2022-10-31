package com.thymeleaf.MyNewWeb.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static DateUtils dateUtils;
	
	private DateUtils() {
	}
	
	public static DateUtils getInstance() {
	  if(dateUtils == null) {
		  dateUtils = new DateUtils();
	  }
	  return dateUtils;
	}
	
	public String getDateByFormat(String format)
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		   LocalDateTime now = LocalDateTime.now();
		   return dtf.format(now);
	}
}
