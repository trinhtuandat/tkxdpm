package com.oms.gui.media;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.abstractdata.ADataSingleViewPaneFactory;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.book.BookEditDialog;
import com.oms.gui.book.BookSingleViewPane;

public class MediaSingleViewPaneFactory extends ADataSingleViewPaneFactory<Media> {
	private static MediaSingleViewPaneFactory singleton = new MediaSingleViewPaneFactory();
	
	public static MediaSingleViewPaneFactory singleton() {
		return singleton;
	}
	
	private MediaSingleViewPaneFactory() {
	}
	
	public ADataSingleViewPane<Media> createDataSingleViewPane(String type){
		if (type.equals("book")) {
			ADataSingleViewPane<Media> visualizationPane = new BookSingleViewPane();
			visualizationPane.addAction("Edit", new IDataActionListener<Media>() {
				@Override
				public void onAct(Media t) {
					new BookEditDialog((Book) t, new IDataActionListener<Media>() {
						@Override
						public void onAct(Media t) {
							System.out.println(t);
							Book newBook = JerseyMediaApi.singleton().updateBook((Book) t);
							visualizationPane.updateData(newBook);
						}
					});
				}
			});
			return visualizationPane;
		}
		return null;
	}
}
