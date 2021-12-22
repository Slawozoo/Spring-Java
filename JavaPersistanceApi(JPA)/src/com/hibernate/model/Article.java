package com.hibernate.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	@Column(name = "published_date")
	private String publishedDate;

	@OneToMany(targetEntity = Author.class)
	private List<Author> authorList = new ArrayList<Author>();
	
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
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public List<Author> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", publishedDate=" + publishedDate + ", authorList="
				+ authorList + "]";
	}
}
