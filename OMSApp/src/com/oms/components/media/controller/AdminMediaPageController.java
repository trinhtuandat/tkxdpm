package com.oms.components.media.controller;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.gui.ADataListViewPane;
import com.oms.components.media.gui.AdminMediaListViewPane;

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
