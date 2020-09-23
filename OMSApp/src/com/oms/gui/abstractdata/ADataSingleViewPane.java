package com.oms.gui.abstractdata;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ADataSingleViewPane<T> extends JPanel {
	protected T t;
	
	protected GridBagLayout layout;
	protected GridBagConstraints c;

	public ADataSingleViewPane() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
	}
	
	public ADataSingleViewPane(T t) {
		this();
		this.t = t;
		
		displayData();
	}
	
	
	public abstract void displayData();
	
	public void addAction(String title, IDataActionListener<T> listener) {
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		JPanel panel = new JPanel();
		this.add(panel, c);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton button = new JButton(title);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onAct(t);
			}
		});
	}
	
	public void updateData(T t) {
		this.t = t;
		displayData();
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
}
