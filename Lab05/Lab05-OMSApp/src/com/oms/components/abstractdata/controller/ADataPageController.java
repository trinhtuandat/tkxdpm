package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSearchPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;

public abstract class ADataPageController<T> {
	private ADataSearchPane searchPane;
	private ADataListPane<T> listPane;
	
	public ADataPageController() {
		searchPane = createSearchPane();
		
		listPane = createListPane();
		
		searchPane.setController(new DataSearchController<T>(listPane, this));
		
		searchPane.fireSearchEvent();
	}

	public ADataSearchPane getSearchPane() {
		return searchPane;
	}

	public ADataListPane<T> getListPane() {
		return listPane;
	}
	
	
	
	public abstract ADataSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract ADataSinglePane<T> createSinglePane();
	
	public abstract ADataListPane<T> createListPane();
}
