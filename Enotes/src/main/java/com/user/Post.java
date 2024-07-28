package com.user;

import java.sql.Timestamp;

public class Post {
	private int id;
	private String title;
	private String contant;
	private Timestamp pDate;
	private UserDetails user;

	public Post(int id, String title, String content, Timestamp pDate, UserDetails user) {
		this.id = id;
		this.title = title;
		this.contant = content;
		this.pDate = pDate;
		this.user = user;
	}

	public Post() {
		super();
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

	public String getContant() {
		return contant;
	}

	public void setContant(String content) {
		this.contant = content;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
