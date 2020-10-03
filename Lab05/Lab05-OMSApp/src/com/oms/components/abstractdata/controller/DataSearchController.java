package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListViewPane;

public class DataSearchController<T> implements IDataSearchController{
	private ADataListViewPane<T> listViewPane;
	private ADataPageController<T> pageController;
	
	public DataSearchController(ADataListViewPane<T> listViewPane, ADataPageController<T> pageController) {
		this.listViewPane = listViewPane;
		this.pageController = pageController;
	}

	@Override
	public void search(Map<String, String> searchParams) {
		List<? extends T> list = pageController.search(searchParams);
		listViewPane.updateData(list);
	}
}
