package com.oms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataEditController;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.ADataPageController;
import com.oms.gui.abstractdata.ADataSingleViewPane;
import com.oms.gui.media.book.BookEditDialog;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	public AdminMediaPageController() {
		super();
	}
	
	@Override
	public ADataListViewPane<Media> createListViewPane() {
		return new ADataListViewPane<Media>() {
			private static final long serialVersionUID = 1L;
			@Override
			public ADataSingleViewPane<Media> createDataSingleViewPane() {
				ADataSingleViewPane<Media> singleView = createSingleViewPane();
				
				JButton button = new JButton("Edit");
				singleView.addDataHandlingComponent(button);
				
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new BookEditDialog(singleView.getData(), new ADataEditController<Media>() {
							@Override
							public void save(Media t) {
								Media newBook = updateMedia(t);
								singleView.updateData(newBook);
							}
						});
						
					}
				});
				
				return singleView;
			}
		};
	}
	
	public abstract Media updateMedia(Media media);
	
}
