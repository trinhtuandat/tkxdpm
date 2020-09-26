package com.oms.gui.media;

import com.oms.UserMediaSingleViewController;
import com.oms.UserMediaSingleViewPaneDecorator;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.ADataSearchController;
import com.oms.gui.abstractdata.ADataSearchPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

@SuppressWarnings("serial")
public class UserBookPagePane extends ADataPagePane<Media> {
	public UserBookPagePane(UserMediaSingleViewController controller, ADataSearchController searchController) {
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

		searchPane.setController(searchController);
		
		searchPane.fireSearchEvent();
		
		buildControls(searchPane, viewPane);
	}
}
