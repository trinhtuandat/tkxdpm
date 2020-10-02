package com.oms.app.admin;

import javax.swing.JPanel;

import com.oms.bean.Media;
import com.oms.components.abstractdata.gui.ADataPagePane;
import com.oms.components.media.book.controller.AdminBookPageController;

public class OMSAdminController {
	public OMSAdminController() {
	}
	
	public JPanel getBookPage() {
		return new ADataPagePane<Media>(new AdminBookPageController());
	}
}
