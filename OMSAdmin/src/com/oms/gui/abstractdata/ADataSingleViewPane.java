package com.oms.gui.abstractdata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ADataSingleViewPane<T> extends JPanel {
	protected T t;

	public ADataSingleViewPane() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public ADataSingleViewPane(T t) {
		this();
		this.t = t;
		
		displayData();
	}
	
	
	public abstract void displayData();
	
	public void addAction(String title, IDataActionListener<T> listener) {
		JButton button = new JButton(title);
		this.add(button);
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
}
