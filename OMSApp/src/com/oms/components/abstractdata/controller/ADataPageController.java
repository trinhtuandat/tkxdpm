package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;

public abstract class ADataPageController<T> {
	private MediaSearchPane searchPane;
	private ADataListPane<T> listPane;
	
	public ADataPageController() {
		searchPane = createSearchPane();
		
		listPane = createListPane();
		
		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends T> list = ADataPageController.this.search(searchParams);
				listPane.updateData(list);
			}
		});
		
		searchPane.fireSearchEvent();
	}

	public MediaSearchPane getSearchPane() {
		return searchPane;
	}

	public ADataListPane<T> getListPane() {
		return listPane;
	}
	
	
	
	public abstract MediaSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract MediaSinglePane createSinglePane();
	
	public abstract ADataListPane<T> createListPane();
}
