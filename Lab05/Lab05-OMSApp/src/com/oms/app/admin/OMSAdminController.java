package com.oms.app.admin;

import javax.swing.JPanel;

import com.oms.factory.PageFactory;

public class OMSAdminController {
	public OMSAdminController() {
	}
	
	public JPanel getPage(String type) {
		return PageFactory.singleton().createAdminPage(type);
	}
}
