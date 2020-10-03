package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListPane;

public class DataSearchController<T> implements IDataSearchController{
	private ADataListPane<T> listPane;
	private ADataPageController<T> pageController;
	
	public DataSearchController(ADataListPane<T> listPane, ADataPageController<T> pageController) {
		this.listPane = listPane;
		this.pageController = pageController;
	}

	@Override
	public void search(Map<String, String> searchParams) {
		List<? extends T> list = pageController.search(searchParams);
		listPane.updateData(list);
	}
}
