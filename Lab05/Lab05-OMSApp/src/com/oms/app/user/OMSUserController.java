package com.oms.app.user;

import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.gui.ADataPagePane;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.controller.UserBookPageController;

public class OMSUserController {
	private CartController cartController;
	
	public OMSUserController() {
		cartController = new CartController();
	}
	
	public JPanel getCartPane() {
		return cartController.getCartPane();
	}
	
	public JPanel getBookPage() {
		UserBookPageController controller = new UserBookPageController();
		controller.setCartController(cartController);
		return new ADataPagePane<Media>(controller.getSearchPane(), controller.getListPane());
	}
}
