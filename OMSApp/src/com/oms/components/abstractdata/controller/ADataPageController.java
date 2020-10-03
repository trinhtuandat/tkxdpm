package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;

public abstract class ADataPageController<T> {
	private MediaSearchPane searchPane;
	private ADataListPane<T> listViewPane;
	
	public ADataPageController() {
		searchPane = createSearchPane();
		
		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends T> list = ADataPageController.this.search(searchParams);
				listViewPane.updateData(list);
			}
		});
		
		listViewPane = createListViewPane();
		
		searchPane.fireSearchEvent();
	}

	public MediaSearchPane getSearchPane() {
		return searchPane;
	}

	public ADataListPane<T> getListViewPane() {
		return listViewPane;
	}
	
	
	
	public abstract MediaSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract MediaSinglePane createSingleViewPane();
	
	public abstract ADataListPane<T> createListViewPane();
}
