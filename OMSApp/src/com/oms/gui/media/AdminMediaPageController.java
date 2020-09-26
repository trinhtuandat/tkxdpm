package com.oms.gui.media;

import com.oms.AdminMediaSingleViewController;
import com.oms.AdminMediaSingleViewPaneDecorator;
import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.abstractdata.IDataActionListener;
import com.oms.gui.media.book.BookEditDialog;
import com.oms.gui.media.book.BookSingleViewPane;

public abstract class AdminMediaPageController extends MediaPageController {
	public AdminMediaPageController() {
		super();
	}
	
	@Override
	public ADataListViewPane<Media> createListViewPane() {
		return new ADataListViewPane<Media>() {
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
								Media newBook = updateMedia(t);
								bookSingleViewPane.updateData(newBook);
							}
						});
					}
				};
				new AdminMediaSingleViewPaneDecorator(bookSingleViewPane, controller);
				return bookSingleViewPane;
			}
		};
	}
	
	public abstract Media updateMedia(Media media);
	
}
