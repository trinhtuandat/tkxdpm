package com.oms.components.cart.controller;

import com.oms.bean.Order;
import com.oms.bean.OrderItem;
import com.oms.components.cart.gui.CartDialog;
import com.oms.components.cart.gui.CartPane;

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
		
		updateCartPane();
	}
	
	private void updateCartPane() {
		cartPane.updateData(getPresentationText());
	}
	
	public CartPane getCartPane() {
		return cartPane;
	}
	
	public void showCartDialog() {
		dialog.setVisible(true);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		order.addOrderItem(orderItem);
		
		dialog.updateData(order);
		updateCartPane();
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
				if (quantity == 0) {
					order.getOrderItems().remove(oi);
					break;
				}
				oi.setQuantity(quantity);
			}
		}
		
		updateCartPane();
	}
}
