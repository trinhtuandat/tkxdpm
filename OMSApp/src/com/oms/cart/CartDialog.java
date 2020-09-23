package com.oms.cart;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.oms.bean.Media;
import com.oms.bean.Order;

@SuppressWarnings("serial")
public class CartDialog extends JDialog{
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private Order<Media> order;
	private JTextField customerNameField;
	private JTextField customerPhoneField;
	private JTextField customerAddressField;
	
	public CartDialog() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel("Customer name"), c);
		c.gridx = 1;
		c.gridy = 0;
		customerNameField = new JTextField(15);
		add(customerNameField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(new JLabel("Customer phone"), c);
		c.gridx = 1;
		c.gridy = 1;
		customerPhoneField = new JTextField(15);
		add(customerPhoneField, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(new JLabel("Customer address"), c);
		c.gridx = 1;
		c.gridy = 2;
		customerAddressField = new JTextField(15);
		add(customerAddressField, c);
		
		this.pack();
		this.setResizable(false);
	}
	public CartDialog(Order<Media> order) {
		this();
		this.order = order;
	}
	
	
	public void updateData(Order<Media> order) {
		this.order = order;
	}
	public String getPresentationText() {
		return order.getItems().size() + " Items, Total Cost: " + order.getTotalCost();
	}
}