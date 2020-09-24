package com.oms;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.bean.OrderItem;
import com.oms.gui.media.MediaSingleViewPane;

public class UserMediaSingleViewPaneDecorator {
	private MediaSingleViewPane singleView;
	private UserMediaSingleViewController controller;
	
	public UserMediaSingleViewPaneDecorator(MediaSingleViewPane singleView, UserMediaSingleViewController controller) {
		this.singleView = singleView;
		this.controller = controller;
		decorate();
	}

	public void decorate() {
		JSpinner spin = new JSpinner();
		spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
		singleView.addDataHandlingComponent(spin);
		spin.setPreferredSize(new Dimension(100, 20));
		
		JButton button = new JButton("Buy");
		singleView.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller!=null) {
					controller.buy(new OrderItem(singleView.getData(), (int)spin.getValue()));
				}
			}
		});
	}
}
