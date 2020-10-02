package com.oms.serverapi.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.Book;

public interface IBookApi {
	public ArrayList<Book> getBooks(Map<String, String> queryStrings);
	public Book updateBook(Book book);
}
