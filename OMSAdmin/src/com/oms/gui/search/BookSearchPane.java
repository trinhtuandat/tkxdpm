package com.oms.gui.search;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class BookSearchPane extends MediaSearchPane {

	public BookSearchPane() {
	}
	
	
	@Override
	public void initControl() {
		super.initControl();
		
		JLabel publisherLabel = new JLabel("Publisher");
		JTextField publisherField = new JTextField(15);
		this.add(publisherLabel);
		this.add(publisherField);
		layout.putConstraint(SpringLayout.WEST, publisherLabel, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, publisherLabel, 5, SpringLayout.SOUTH, theLastComponent);
		layout.putConstraint(SpringLayout.WEST, publisherField, 80, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, publisherField, 2, SpringLayout.SOUTH, theLastComponent);
		
		theLastComponent = publisherLabel;
	}
	
	
	public String generateQuery() {
		return "{}";
	}
}
