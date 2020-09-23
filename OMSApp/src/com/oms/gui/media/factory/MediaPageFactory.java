package com.oms.gui.media.factory;

import java.util.List;
import java.util.Map;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.abstractdata.factory.ADataPageFactory;
import com.oms.gui.media.book.BookSearchPane;

public class MediaPageFactory extends ADataPageFactory<Media> {
	private static ADataPageFactory<Media> singleton = new MediaPageFactory();
	
	public static ADataPageFactory<Media> singleton() {
		return singleton;
	}
	
	private MediaPageFactory() {
	}
	
	public ADataPagePane<Media> createDataPagePane(String type){
		BookSearchPane searchPane = new BookSearchPane();
		
		@SuppressWarnings("serial")
		ADataListViewPane<Media> viewPane = new ADataListViewPane<Media>() {
			@Override
			public ADataSingleViewPane<Media> createDataSingleViewPane() {
				return MediaSingleViewPaneFactory.singleton().createDataSingleViewPane(type);
			}
		};

		ADataPagePane<Media> managePane = new ADataPagePane<Media>(searchPane, viewPane);
		
		if (type.equals("admin.book") || type.equals("user.book")) {
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
