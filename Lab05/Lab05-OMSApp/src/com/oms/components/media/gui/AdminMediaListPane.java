package com.oms.components.media.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.media.book.gui.BookEditDialog;
import com.oms.components.media.controller.AdminMediaPageController;

@SuppressWarnings("serial")
public class AdminMediaListPane extends ADataListPane<Media>{
	private AdminMediaPageController pageController;
	
	public AdminMediaListPane(AdminMediaPageController pageController) {
		this.pageController = pageController;
	}
	
	@Override
	public ADataSinglePane<Media> createDataSinglePane() {
		ADataSinglePane<Media> singlePane = pageController.createSinglePane();
		
		JButton button = new JButton("Edit");
		singlePane.addDataHandlingComponent(button);
		IDataManageController<Media> controller = new IDataManageController<Media>() {
			@Override
			public void update(Media t) {
				Media newMedia = pageController.updateMedia(t);
				singlePane.updateData(newMedia);
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
				new BookEditDialog(singlePane.getData(), controller);
				
			}
		});
		
		return singlePane;
	}
}
