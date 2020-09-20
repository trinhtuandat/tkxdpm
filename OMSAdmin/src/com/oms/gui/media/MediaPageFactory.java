package com.oms.gui.media;

import java.util.List;
import java.util.Map;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.abstractdata.ADataPageFactory;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.DataListViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.book.BookSearchPane;

public class MediaPageFactory extends ADataPageFactory<Media> {
	private static MediaPageFactory singleton = new MediaPageFactory();
	
	public static MediaPageFactory singleton() {
		return singleton;
	}
	
	private MediaPageFactory() {
	}
	
	public ADataPagePane<Media> createDataManagePane(String type){
		if (type.equals("book")) {
			BookSearchPane searchPane = new BookSearchPane();
			DataListViewPane<Media> viewPane = new DataListViewPane<Media>();
			ADataPagePane<Media> managePane = new ADataPagePane<Media>(searchPane, viewPane);
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
