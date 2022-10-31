//package com.thymeleaf.MyNewWeb.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	@Qualifier ("appDataSource")
//	private DataSource securityDataSource;
//	
////	@Bean
////	public BCryptPasswordEncoder passwordEncoder ()
////	{
////		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
////		return bCryptPasswordEncoder;
////	}
//	
//	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.jdbcAuthentication().dataSource(securityDataSource);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
////			.antMatchers("/employees/showForm*").hasAnyRole("Mod", "Admin")
////			.antMatchers("/employees/save*").hasAnyRole("Mod", "Admin")
////			.antMatchers("/employees/delete").hasRole("Admin")
//			.antMatchers("/**").hasAnyRole("User", "Mod", "Admin")
//			.antMatchers("/resources/**").permitAll()
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//			.logout().permitAll()
//			.and()
//			.exceptionHandling().accessDeniedPage("/access-denied");
//		
//	}
//		
//
//}
