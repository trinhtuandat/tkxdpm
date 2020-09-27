package com.oms.cart.controller;

import com.oms.bean.Order;
import com.oms.bean.OrderItem;
import com.oms.cart.gui.CartDialog;
import com.oms.cart.gui.CartPane;

public class CartController {
	private CartPane cartPane;
	private CartDialog dialog;
	private Order order;
	
	public CartController() {
		order = new Order();
		dialog = new CartDialog();
		cartPane = new CartPane();
		
		cartPane.setController(this);
		dialog.setController(this);
		
		cartPane.updatePresentationText(getPresentationText());
	}
	
	public CartPane getCartPane() {
		return cartPane;
	}
	
	public void showCartDialog() {
		dialog.setVisible(true);
	}
	
	public void addItem(OrderItem orderItem) {
		order.addOrderItem(orderItem);
		
		dialog.updateData(order);
		cartPane.updatePresentationText(getPresentationText());
	}
	
	public String getPresentationText() {
		int numberOfItems = 0;
		if ( order.getOrderItems() != null) {
			numberOfItems = order.getOrderItems().size();
		}
		return "Your cart has " + numberOfItems + " items. Total Cost: " + order.getTotalCost();
	}
	
	public void checkOut() {
		System.out.println("Checkout!!!");
	}
	
	public void setOrderItemQuantity(OrderItem orderItem, int quantity) {
		for (OrderItem oi: order.getOrderItems()) {
			if (oi == orderItem) {
				oi.setQuantity(quantity);
			}
		}
	}
}
