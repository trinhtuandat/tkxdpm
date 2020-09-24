package com.oms.gui.media.factory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchController;
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
					
					JSpinner spin = new JSpinner();
					spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
					singlePane.addDataHandlingComponent(spin);
					spin.setPreferredSize(new Dimension(100, 20));
					
					JButton button = new JButton("Buy");
					singlePane.addDataHandlingComponent(button);
					
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (listener!=null) {
								listener.onAct(new OrderItem(singlePane.getData(), (int)spin.getValue()));
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
