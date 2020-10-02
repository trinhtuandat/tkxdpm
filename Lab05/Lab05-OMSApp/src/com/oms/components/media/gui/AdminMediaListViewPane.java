package com.oms.components.media.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataListViewPane;
import com.oms.components.abstractdata.gui.ADataSingleViewPane;
import com.oms.components.media.book.gui.BookEditDialog;
import com.oms.components.media.controller.AdminMediaPageController;

@SuppressWarnings("serial")
public class AdminMediaListViewPane extends ADataListViewPane<Media>{
	private AdminMediaPageController pageController;
	
	public AdminMediaListViewPane(AdminMediaPageController pageController) {
		this.pageController = pageController;
	}
	
	@Override
	public ADataSingleViewPane<Media> createDataSingleViewPane() {
		ADataSingleViewPane<Media> singleView = pageController.createSingleViewPane();
		
		JButton button = new JButton("Edit");
		singleView.addDataHandlingComponent(button);
		IDataManageController<Media> controller = new IDataManageController<Media>() {
			@Override
			public void update(Media t) {
				Media newMedia = pageController.updateMedia(t);
				singleView.updateData(newMedia);
			}

			@Override
			public void create(Media t) {
			}

			@Override
			public void read(Media t) {
			}

			@Override
			public void delete(Media t) {
				
			}
		};
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BookEditDialog(singleView.getData(), controller);
				
			}
		});
		
		return singleView;
	}
}
