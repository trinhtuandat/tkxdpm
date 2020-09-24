package com.oms.gui.media.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchController;
import com.oms.gui.abstractdata.ADataSearchPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.abstractdata.factory.ADataPageFactory;
import com.oms.gui.media.book.BookEditDialog;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

public class MediaAdminPageFactory extends ADataPageFactory<Media, Media> {
	private static ADataPageFactory<Media, Media> singleton = new MediaAdminPageFactory();
	
	public static ADataPageFactory<Media, Media> singleton() {
		return singleton;
	}
	
	private MediaAdminPageFactory() {
	}
	
	public ADataPagePane<Media> createDataPagePane(String type, IDataActionListener<Media> listener){
		if (type.equals("book")) {
			ADataSearchPane searchPane = new BookSearchPane();
			
			ADataListViewPane<Media> viewPane = new ADataListViewPane<Media>() {
				private static final long serialVersionUID = 1L;
				@Override
				public ADataSingleViewPane<Media> createDataSingleViewPane() {
					ADataSingleViewPane<Media> singlePane = new BookSingleViewPane();
					
					JButton button = new JButton("Edit");
					singlePane.addDataHandlingComponent(button);
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Book book = (Book) singlePane.getData();
							
							new BookEditDialog(book, new IDataActionListener<Media>() {
								@Override
								public void onAct(Media t) {
									System.out.println(t);
									Book newBook = JerseyMediaApi.singleton().updateBook((Book) t);
									singlePane.updateData(newBook);
								}
							});
							
							if (listener!=null) {
								listener.onAct(book);
							}
						}
					});
					return singlePane;
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
