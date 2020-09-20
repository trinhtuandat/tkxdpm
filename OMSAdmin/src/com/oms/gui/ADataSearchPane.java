package com.oms.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ADataSearchPane extends JPanel {
	protected GridBagLayout layout;
	protected GridBagConstraints c;

	public ADataSearchPane(IDataActionListener<Map<String, String>> onSearchListener) {
		layout = new GridBagLayout();
		this.setLayout(layout);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 2;
		c.gridy = row - 1;
		JButton searchButton = new JButton("Search");
		add(searchButton, c);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSearchListener.onAct(getQueryParams());
			}
		});
		

		// Empty label for resizing
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = row - 1;
		add(new JLabel(), c);
	}
	
	public abstract void buildControls();
	
	public Map<String, String> getQueryParams() {
		Map<String, String> res = new HashMap<String, String>();
		return res;
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
}
