package com.thymeleaf.MyNewWeb.entity;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;


@Entity
@Table (name="account")
public class Account {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column (name="user_name")
	private String userName;
	
	@Column (name="pwd")
	@NotNull
	@Size (min=8, message="is requried")
	private String password;
	
	@Column (name="display_name")
	private String displayName;
	
	@Column (name="email")
	private String email;
	
	
	
	@Column (name="phone_number")
	private String phoneNumber;

	@Column (name="gender")
	private int gender;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user_name=" + userName + ", password=" + password + ", displayName="
				+ displayName + "]";
	}

	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}



	public Account(String userName, @NotNull @Size(min = 8, message = "is requried") String password,
			String displayName, String email, String phoneNumber, int gender, List<Post> post) {
		this.userName = userName;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.post = post;
	}

	public Account() {
	}
	
	@OneToMany (mappedBy="account", fetch = FetchType.EAGER)
	@Cascade ({CascadeType.ALL})
	private List<Post> post;
	
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public void add (Post thePost)
	{
		if (post == null)
		{
			post = new ArrayList<>();
		}
		thePost.setAccount(this);
		post.add(thePost);
		
	}
	
}
