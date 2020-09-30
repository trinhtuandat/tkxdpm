package com.oms.app.user;

import javax.swing.JPanel;

import com.oms.components.cart.controller.CartController;
import com.oms.factory.PageFactory;

public class OMSUserController {
	private CartController cartController;
	
	public OMSUserController() {
		cartController = new CartController();
	}
	
	public JPanel getCartPane() {
		return cartController.getCartPane();
	}
	
	public JPanel getPage(String type) {
		return PageFactory.singleton().createUserPage(type, cartController);
	}
}
