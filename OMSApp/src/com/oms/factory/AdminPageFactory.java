package com.oms.factory;

import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.media.book.controller.AdminBookPageController;

public class AdminPageFactory {
	private static AdminPageFactory singleton = new AdminPageFactory();
	
	public static AdminPageFactory singleton() {
		return singleton;
	}
	
	private AdminPageFactory() {
	}
	
	public JPanel createPage(String type) {
		switch (type) {
		case "book":
			ADataPageController<Media> controller = new AdminBookPageController();
			return controller.getDataPagePane();
		default:
			return null;
		}
	}
}
