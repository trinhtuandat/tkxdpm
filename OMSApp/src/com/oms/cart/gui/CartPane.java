package com.oms.cart.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oms.bean.Order;
import com.oms.bean.OrderItem;

@SuppressWarnings("serial")
public class CartPane extends JPanel{
	private Order order;
	private JLabel cartStatusLabel;
	private CartDialog dialog;
	
	public CartPane() {
		order = new Order();
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		cartStatusLabel = new JLabel(getPresentationText());
		this.add(cartStatusLabel);
		JButton detailButton = new JButton("Detail");
		this.add(detailButton);
		
		dialog = new CartDialog();
		
		detailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
	}
	public CartPane(Order order) {
		this();
		this.order = order;
	}
	
	public void addItem(OrderItem orderItem) {
		order.addOrderItem(orderItem);
		dialog.updateData(order);
		updateData();
	}
	
	public void updateData() {
		cartStatusLabel.setText(getPresentationText());
	}

	public String getPresentationText() {
		int numberOfItems = 0;
		if ( order.getOrderItems() != null) {
			numberOfItems = order.getOrderItems().size();
		}
		return "Your cart has " + numberOfItems + " items. Total Cost: " + order.getTotalCost();
	}
}