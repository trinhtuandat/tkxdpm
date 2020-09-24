package com.oms.gui.media.factory;

import java.util.List;
import java.util.Map;

import com.oms.AdminMediaSingleViewController;
import com.oms.AdminMediaSingleViewPaneDecorator;
import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchController;
import com.oms.gui.abstractdata.ADataSearchPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.media.book.BookEditDialog;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

public class MediaAdminPageFactory {
	private static MediaAdminPageFactory singleton = new MediaAdminPageFactory();
	
	public static MediaAdminPageFactory singleton() {
		return singleton;
	}
	
	private MediaAdminPageFactory() {
	}
	
	public ADataPagePane<Media> createDataPagePane(String type){
		if (type.equals("book")) {
			ADataSearchPane searchPane = new BookSearchPane();
			
			ADataListViewPane<Media> viewPane = new ADataListViewPane<Media>() {
				private static final long serialVersionUID = 1L;
				@Override
				public ADataSingleViewPane<Media> createDataSingleViewPane() {
					BookSingleViewPane bookSingleViewPane = new BookSingleViewPane();
					AdminMediaSingleViewController controller = new AdminMediaSingleViewController() {
						@Override
						public void edit(Media media) {
							new BookEditDialog(media, new IDataActionListener<Media>() {
								@Override
								public void onAct(Media t) {
									System.out.println(t);
									Book newBook = JerseyMediaApi.singleton().updateBook((Book) t);
									bookSingleViewPane.updateData(newBook);
								}
							});
						}
					};
					new AdminMediaSingleViewPaneDecorator(bookSingleViewPane, controller);
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
