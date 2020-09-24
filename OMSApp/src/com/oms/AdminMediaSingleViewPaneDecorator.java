package com.oms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.gui.media.MediaSingleViewPane;

public class AdminMediaSingleViewPaneDecorator {
	private MediaSingleViewPane singleView;
	private AdminMediaSingleViewController controller;
	
	public AdminMediaSingleViewPaneDecorator(MediaSingleViewPane singleView, AdminMediaSingleViewController controller) {
		this.singleView = singleView;
		this.controller = controller;
		decorate();
	}

	public void decorate() {
		JButton button = new JButton("Edit");
		singleView.addDataHandlingComponent(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.edit(singleView.getData());
			}
		});
	}
}
