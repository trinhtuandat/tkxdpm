package com.oms.gui.search;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class MediaSearchPane extends JPanel {
	protected SpringLayout layout;
	protected JComponent theLastComponent;

	public MediaSearchPane() {
		initControl();
	}
	
	public void initControl() {
		layout = new SpringLayout();
		this.setLayout(layout);

		JLabel titleLabel = new JLabel("Title");
		JTextField titleField = new JTextField(15);
		this.add(titleLabel);
		this.add(titleField);
		layout.putConstraint(SpringLayout.WEST, titleLabel, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titleLabel, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, titleField, 80, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titleField, 0, SpringLayout.NORTH, this);
		
		
		JButton searchButton = new JButton("Search");
		this.add(searchButton);
		layout.putConstraint(SpringLayout.WEST, searchButton, 5, SpringLayout.EAST, titleField);
		layout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, this);
		
		
		
		JLabel categoryLabel = new JLabel("Category");
		JTextField categoryField = new JTextField(15);
		this.add(categoryLabel);
		this.add(categoryField);
		layout.putConstraint(SpringLayout.WEST, categoryLabel, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, categoryLabel, 5, SpringLayout.SOUTH, titleLabel);
		layout.putConstraint(SpringLayout.WEST, categoryField, 80, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, categoryField, 2, SpringLayout.SOUTH, titleLabel);
		
		
		JLabel costLabel = new JLabel("Cost");
		JTextField costField = new JTextField(15);
		this.add(costLabel);
		this.add(costField);
		layout.putConstraint(SpringLayout.WEST, costLabel, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, costLabel, 5, SpringLayout.SOUTH, categoryLabel);
		layout.putConstraint(SpringLayout.WEST, costField, 80, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, costField, 2, SpringLayout.SOUTH, categoryLabel);
		
		theLastComponent = costLabel;
	}
}
