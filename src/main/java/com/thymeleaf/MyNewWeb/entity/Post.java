package com.thymeleaf.MyNewWeb.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table (name="post")
//@SecondaryTable (name = "account", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName="id" ))
public class Post {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column (name="title")
	private String title;
	
	@Column (name="create_date")
	private String createDate;
	
	@Column (name="content")
	private String content;
	
	 @ManyToOne ( fetch = FetchType.LAZY)
	 @Cascade ({CascadeType.SAVE_UPDATE, CascadeType.DETACH, CascadeType.REFRESH})
	 @JoinColumn (name ="user_id", nullable = false)
	 private Account account;
	
	
	public Post(String title, String create_date, String content) {
		this.title = title;
		this.createDate = create_date;
		this.content = content;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", create_date=" + createDate + ", content=" + content
				+ "]";
	}
	public Post() {
		
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}
