package com.oms.bean.media;

import java.util.ArrayList;
import java.util.Date;

public class Book extends PhysicalMedia {
	private String publisher;
	private Date publicationDate;
	private ArrayList<String> authors = new ArrayList<String>();
	private int numberOfPages;
	private String language;
	
	public Book() {
		super();
	}

	public Book(String publisher, Date publicationDate, ArrayList<String> authors, int numberOfPages, String language) {
		super();
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.authors = authors;
		this.numberOfPages = numberOfPages;
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", publisher: " + publisher + ", publication date: " + publicationDate;
	}
}