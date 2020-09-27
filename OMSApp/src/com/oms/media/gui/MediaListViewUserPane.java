package com.oms.media.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.abstractdata.gui.ADataSingleViewPane;
import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.media.controller.UserMediaPageController;

@SuppressWarnings("serial")
public class MediaListViewUserPane extends ADataListViewPane<Media>{
	private UserMediaPageController controller;
	
	
	public MediaListViewUserPane(UserMediaPageController controller) {
		this.controller = controller;
	}
	

	@Override
	public ADataSingleViewPane<Media> createDataSingleViewPane() {
		ADataSingleViewPane<Media> singleView = controller.createSingleViewPane();
		
		JSpinner spin = new JSpinner();
		spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
		singleView.addDataHandlingComponent(spin);
		spin.setPreferredSize(new Dimension(100, 20));
		
		JButton button = new JButton("Add to cart");
		singleView.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addToCart(new OrderItem(singleView.getData(), (int)spin.getValue()));
			}
		});
		
		return singleView;
	}
}
