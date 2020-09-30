package com.oms.app.admin;

import javax.swing.JPanel;

import com.oms.factory.AdminPageFactory;

public class OMSAdminController {
	public OMSAdminController() {
	}
	
	public JPanel getPage(String type) {
		return AdminPageFactory.singleton().createPage(type);
	}
}
