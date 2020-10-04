package com.oms.components.media.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.media.controller.UserMediaPageController;

@SuppressWarnings("serial")
public class UserMediaListPane extends ADataListPane<Media>{
	private UserMediaPageController controller;
	
	
	public UserMediaListPane(UserMediaPageController controller) {
		this.controller = controller;
	}
	

	@Override
	public ADataSinglePane<Media> createDataSinglePane() {
		ADataSinglePane<Media> singlePane = controller.createSinglePane();
		
		JSpinner spin = new JSpinner();
		spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
		singlePane.addDataHandlingComponent(spin);
		spin.setPreferredSize(new Dimension(100, 20));
		
		JButton button = new JButton("Add to cart");
		singlePane.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addToCart(new OrderItem(singlePane.getData(), (int)spin.getValue()));
			}
		});
		
		return singlePane;
	}
}