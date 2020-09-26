package com.oms.abstractdata.gui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.oms.abstractdata.controller.ADataPageController;

@SuppressWarnings("serial")
public class ADataPagePane<T> extends JPanel{
	public ADataPagePane(ADataPageController<T> controller) {
		this(controller.getSearchPane(), controller.getListViewPane());
	}
	
	public ADataPagePane(ADataSearchPane searchPane, ADataListViewPane<T> viewPane) {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.add(searchPane);
		this.add(viewPane);
		
		
		layout.putConstraint(SpringLayout.WEST, searchPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, searchPane, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, searchPane, -5, SpringLayout.EAST, this);
		
		
		layout.putConstraint(SpringLayout.WEST, viewPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, viewPane, 5, SpringLayout.SOUTH, searchPane);
		layout.putConstraint(SpringLayout.EAST, viewPane, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, viewPane, -5, SpringLayout.SOUTH, this);
	}
}
