package com.oms.factory;

import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.gui.ADataPagePane;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.controller.UserBookPageController;

public class UserPageFactory {
	private static UserPageFactory singleton = new UserPageFactory();
	
	public static UserPageFactory singleton() {
		return singleton;
	}
	
	private UserPageFactory() {
	}
	
	public JPanel createPage(String type, CartController cartController) {
		switch (type) {
		case "book":
			return new ADataPagePane<Media>(new UserBookPageController(cartController));
		default:
			return null;
		}
	}
}
