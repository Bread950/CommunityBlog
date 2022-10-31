package com.thymeleaf.MyNewWeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

import com.thymeleaf.MyNewWeb.entity.Account;

public interface AccountRepository extends JpaRepository <Account, Integer>{
	@Query (value = "SELECT * FROM account a where a.id=:userId" , 
            nativeQuery=true)
	public Account findByUserId (@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query ("UPDATE Account a SET a.phoneNumber=:phoneNumber, a.email=:email, a.gender=:gender,a.displayName=:displayName"
			+ " where a.id=:id")
	public void update(@Param ("phoneNumber") String phoneNumber, @Param("email") String email,  @Param ("gender") int gender,
			@Param ("displayName") String displayName, @Param ("id") int id );
}
