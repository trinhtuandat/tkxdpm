package com.oms.media.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.abstractdata.controller.ADataManageController;
import com.oms.abstractdata.controller.IDataManageController;
import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.abstractdata.gui.ADataSingleViewPane;
import com.oms.bean.Media;
import com.oms.media.book.gui.BookEditDialog;
import com.oms.media.controller.AdminMediaPageController;

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
		IDataManageController<Media> controller = new ADataManageController<Media>() {
			@Override
			public void update(Media t) {
				Media newMedia = pageController.updateMedia(t);
				singleView.updateData(newMedia);
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
