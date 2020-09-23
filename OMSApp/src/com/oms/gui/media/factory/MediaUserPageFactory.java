package com.oms.gui.media.factory;

import java.util.List;
import java.util.Map;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.abstractdata.factory.ADataPageFactory;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

public class MediaUserPageFactory extends ADataPageFactory<Media, OrderItem> {
	private static ADataPageFactory<Media, OrderItem> singleton = new MediaUserPageFactory();
	
	public static ADataPageFactory<Media, OrderItem> singleton() {
		return singleton;
	}
	
	private MediaUserPageFactory() {
	}
	
	public ADataPagePane<Media> createDataPagePane(String type, IDataActionListener<OrderItem> listener){
		if (type.equals("book")) {
			ADataSearchPane searchPane = new BookSearchPane();
			
			ADataListViewPane<Media> viewPane = new ADataListViewPane<Media>() {
				private static final long serialVersionUID = 1L;
				@Override
				public ADataSingleViewPane<Media> createDataSingleViewPane() {
					ADataSingleViewPane<Media> singlePane = new BookSingleViewPane();
					singlePane.addAction("Buy", new IDataActionListener<Media>() {
						@Override
						public void onAct(Media t) {
							System.out.println("Buy this!");
							
							if (listener!=null) {
								listener.onAct(new OrderItem(t, 1));
							}
						}
					});
					return singlePane;
				}
			};
			
			searchPane.setOnSearchListener(new IDataActionListener<Map<String,String>>() {
				@Override
				public void onAct(Map<String, String> queryParams) {
					List<Book> books = JerseyMediaApi.singleton().getBooks(queryParams);
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
