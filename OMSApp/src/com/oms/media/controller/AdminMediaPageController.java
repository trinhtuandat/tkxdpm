package com.oms.media.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.abstractdata.controller.ADataEditController;
import com.oms.abstractdata.controller.ADataPageController;
import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.abstractdata.gui.ADataSingleViewPane;
import com.oms.bean.Media;
import com.oms.media.book.gui.BookEditDialog;

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