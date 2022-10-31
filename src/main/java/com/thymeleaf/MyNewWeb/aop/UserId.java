package com.thymeleaf.MyNewWeb.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.thymeleaf.MyNewWeb.entity.Post;

@Aspect
@Component
public class UserId {
	@Pointcut ("execution (* com.thymeleaf.MyNewWeb.dao.PostRepository.findById(..))")
	public void getInfoDAO () {}
	@Pointcut ("execution (* com.thymeleaf.MyNewWeb.service.AccountServiceImpl.checkAccount(..))")
	public void getInfoAccount () {}
	
	@AfterReturning (pointcut = "getInfoDAO()", returning = "result")
	public void getId (JoinPoint theJoinpoint, List<Post> result)
	{
		String method = theJoinpoint.getSignature().toShortString();
		System.out.println("========>" + method);
		System.out.println("========>" + result);
	}
}
