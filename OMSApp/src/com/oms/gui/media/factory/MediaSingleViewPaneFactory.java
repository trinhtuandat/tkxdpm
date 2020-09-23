package com.oms.gui.media.factory;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.abstractdata.factory.ADataSingleViewPaneFactory;
import com.oms.gui.media.book.BookEditDialog;
import com.oms.gui.media.book.BookSingleViewPane;

public class MediaSingleViewPaneFactory extends ADataSingleViewPaneFactory<Media> {
	private static ADataSingleViewPaneFactory<Media> singleton = new MediaSingleViewPaneFactory();
	
	public static ADataSingleViewPaneFactory<Media> singleton() {
		return singleton;
	}
	
	private MediaSingleViewPaneFactory() {
	}
	
	public ADataSingleViewPane<Media> createDataSingleViewPane(String type){
		if (type.equals("admin.book")) {
			ADataSingleViewPane<Media> singlePane = new BookSingleViewPane();
			singlePane.addAction("Edit", new IDataActionListener<Media>() {
				@Override
				public void onAct(Media t) {
					new BookEditDialog((Book) t, new IDataActionListener<Media>() {
						@Override
						public void onAct(Media t) {
							System.out.println(t);
							Book newBook = JerseyMediaApi.singleton().updateBook((Book) t);
							singlePane.updateData(newBook);
						}
					});
				}
			});
			return singlePane;
		}
		if (type.equals("user.book")) {
			ADataSingleViewPane<Media> singlePane = new BookSingleViewPane();
			singlePane.addAction("Buy", new IDataActionListener<Media>() {
				@Override
				public void onAct(Media t) {
					System.out.println("Buy this!");
				}
			});
			return singlePane;
		}
		return null;
	}
}
