package com.oms.media.controller;

import com.oms.abstractdata.controller.ADataPageController;
import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.bean.Media;
import com.oms.media.gui.AdminMediaListViewPane;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	public AdminMediaPageController() {
		super();
	}
	
	@Override
	public ADataListViewPane<Media> createListViewPane() {
		return new AdminMediaListViewPane(this);
	}
	
	public abstract Media updateMedia(Media media);
	
}
