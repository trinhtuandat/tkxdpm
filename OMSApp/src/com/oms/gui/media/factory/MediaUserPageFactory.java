package com.oms.gui.media.factory;

import java.util.List;
import java.util.Map;

import com.oms.UserMediaSingleViewController;
import com.oms.UserMediaSingleViewPaneDecorator;
import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchController;
import com.oms.gui.abstractdata.ADataSearchPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

public class MediaUserPageFactory {
	private static MediaUserPageFactory singleton = new MediaUserPageFactory();
	
	public static MediaUserPageFactory singleton() {
		return singleton;
	}
	
	private MediaUserPageFactory() {
	}
	
	public ADataPagePane<Media> createDataPagePane(String type, UserMediaSingleViewController controller){
		if (type.equals("book")) {
			ADataSearchPane searchPane = new BookSearchPane();
			
			ADataListViewPane<Media> viewPane = new ADataListViewPane<Media>() {
				private static final long serialVersionUID = 1L;
				@Override
				public ADataSingleViewPane<Media> createDataSingleViewPane() {
					BookSingleViewPane bookSingleViewPane = new BookSingleViewPane();
					new UserMediaSingleViewPaneDecorator(bookSingleViewPane, controller);
					return bookSingleViewPane;
				}
			};

			searchPane.setController(new ADataSearchController() {
				@Override
				public void search(Map<String, String> searchParams) {
					List<Book> books = JerseyMediaApi.singleton().getBooks(searchParams);
					viewPane.updateData(books);
				}
			});
			
			searchPane.fireSearchEvent();
			ADataPagePane<Media> managePane = new ADataPagePane<Media>(searchPane, viewPane);
			return managePane;
		}
		
		return null;
	}
}
