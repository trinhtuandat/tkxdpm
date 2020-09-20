package com.oms.gui.abstractdata;

import java.util.List;
import java.util.Map;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.media.Book;
import com.oms.gui.book.BookSearchPane;

public class DataPageFactory extends ADataPageFactory<Book> {
	private static DataPageFactory singleton = new DataPageFactory();
	
	public static DataPageFactory singleton() {
		return singleton;
	}
	
	private DataPageFactory() {
	}
	
	public ADataPagePane<Book> createDataManagePane(String type){
		if (type.equals("book")) {
			BookSearchPane searchPane = new BookSearchPane();
			DataListViewPane<Book> viewPane = new DataListViewPane<Book>();
			ADataPagePane<Book> managePane = new ADataPagePane<Book>(searchPane, viewPane);
			searchPane.setOnSearchListener(new IDataActionListener<Map<String,String>>() {
				@Override
				public void onAct(Map<String, String> queryParams) {
					List<Book> books = JerseyMediaApi.singleton().getBooks(queryParams);
					viewPane.updateData(books);
				}
			});
			searchPane.fireSearchEvent();
			
			return managePane;
		}
		return null;
	}
}
