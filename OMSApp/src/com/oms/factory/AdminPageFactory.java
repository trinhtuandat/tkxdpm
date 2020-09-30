package com.oms.factory;

import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.gui.ADataPagePane;
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
			return new ADataPagePane<Media>(new AdminBookPageController());
		default:
			return null;
		}
	}
}
