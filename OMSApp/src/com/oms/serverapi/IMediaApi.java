package com.oms.serverapi;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;
import com.oms.bean.DigitalVideoDisc;
import com.oms.bean.Media;

public interface IMediaApi {
	public ArrayList<Media> getAllMedias();
	
	
	public ArrayList<Book> getBooks(Map<String, String> queryStrings);
	public Book updateBook(Book book);
	
	
	
	public ArrayList<CompactDisc> getCds(Map<String, String> queryStrings);
	
	
	
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryStrings);
}
