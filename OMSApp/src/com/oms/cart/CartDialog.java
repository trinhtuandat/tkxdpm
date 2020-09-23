package com.oms.cart;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.oms.bean.Order;
import com.oms.bean.OrderItem;

@SuppressWarnings("serial")
public class CartDialog extends JDialog{
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private JTextField customerNameField;
	private JTextField customerPhoneField;
	private JTextField customerAddressField;
	
	public CartDialog() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		c = new GridBagConstraints();
		updateData(null);
	}
	
	public void updateData(Order order) {
		this.getContentPane().removeAll();

		c.insets = new Insets(10,0,5,0);
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel("Customer name"), c);
		c.gridx = 1;
		c.gridy = 0;
		customerNameField = new JTextField(15);
		add(customerNameField, c);
		
		c.insets = new Insets(0,0,5,0);
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
		
		if (order != null) {
			for (int i=0; i<order.getOrderItems().size(); ++i) {
				OrderItem oi = order.getOrderItems().get(i);
				
				c.gridx = 0;
				c.gridy = 3 + i;
				add(new JLabel(oi.getMedia().getTitle()), c);
				
				c.gridx = 1;
				c.gridy = 3 + i;
				JSpinner spin = new JSpinner();
				spin.setModel(new SpinnerNumberModel(oi.getQuantity(), 0, null, 1));
				add(spin, c);
				spin.setPreferredSize(new Dimension(190, 20));
			}
		}

		this.revalidate();
		this.repaint();
		this.pack();
		this.setResizable(false);
	}
}