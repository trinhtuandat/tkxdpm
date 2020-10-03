package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListPane;

public class DataSearchController<T> implements IDataSearchController{
	private ADataListPane<T> listViewPane;
	private ADataPageController<T> pageController;
	
	public DataSearchController(ADataListPane<T> listViewPane, ADataPageController<T> pageController) {
		this.listViewPane = listViewPane;
		this.pageController = pageController;
	}

	@Override
	public void search(Map<String, String> searchParams) {
		List<? extends T> list = pageController.search(searchParams);
		listViewPane.updateData(list);
	}
}
