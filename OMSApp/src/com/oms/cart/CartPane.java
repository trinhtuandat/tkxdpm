package com.oms.cart;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.bean.Order;

@SuppressWarnings("serial")
public class CartPane extends JPanel{
	private Order<Media> order;
	
	public CartPane() {
		order = new Order<Media>();
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(new JLabel(getPresentationText()));
		JButton detailButton = new JButton("Detail");
		this.add(detailButton);
		
		CartDialog dialog = new CartDialog();
		
		detailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
	}
	public CartPane(Order<Media> order) {
		this();
		this.order = order;
	}

	public String getPresentationText() {
		int numberOfItems = 0;
		if ( order.getItems() != null) {
			numberOfItems = order.getItems().size();
		}
		return "Your cart has " + numberOfItems + " items. Total Cost: " + order.getTotalCost();
	}
}