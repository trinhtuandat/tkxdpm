package com.oms.bean.media;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book extends Media implements Comparable {

	private java.util.ArrayList<String> authors = new java.util.ArrayList<String>();
	
	/**
	 *  
	 */
	public Book() {
		super();
	}


	public void addAuthor(String authorName) {
		// ensure that the author is not already in
		// the ArrayList before adding
		if (!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		// ensure that the author is present in the
		// ArrayList before removing
		if ((authors.contains(authorName))) {
			authors.remove(authorName);
		}
	}
	
	public int compareTo(Object obj) {
		Media media = (Media)obj;
		return(this.getTitle()).compareTo(media.getTitle());
	}
	
	public ArrayList<String> getAuthors(){
		return this.authors;
	}
	
	public void setAuthors(ArrayList<String> authors){
		this.authors = authors;;
	}
}