package com.packages.annotationconfig;

import java.util.List;

public class Article {
		private String title;
		private String publishedDate;
		private List<Author> author;
	
		public Article() {
			super();
		}

		public Article(String title, String publishedDate, List<Author> author) {
			super();
			this.title = title;
			this.publishedDate = publishedDate;
			this.author = author;
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

		public List<Author> getAuthor() {
			return author;
		}

		public void setAuthor(List<Author> author) {
			this.author = author;
		}

		
		
}
