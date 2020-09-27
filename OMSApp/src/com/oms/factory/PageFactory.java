package com.oms.factory;

import javax.swing.JPanel;

import com.oms.abstractdata.gui.ADataPagePane;
import com.oms.bean.Media;
import com.oms.cart.controller.CartController;
import com.oms.media.book.controller.AdminBookPageController;
import com.oms.media.book.controller.UserBookPageController;

public class PageFactory {
	private static PageFactory singleton = new PageFactory();
	
	public static PageFactory singleton() {
		return singleton;
	}
	
	private PageFactory() {
	}
	
	public JPanel createUserPage(String type, CartController cartController) {
		switch (type) {
		case "book":
			return new ADataPagePane<Media>(new UserBookPageController(cartController));
		default:
			return null;
		}
	}
	
	public JPanel createAdminPage(String type) {
		switch (type) {
		case "book":
			return new ADataPagePane<Media>(new AdminBookPageController());
		default:
			return null;
		}
	}
}
