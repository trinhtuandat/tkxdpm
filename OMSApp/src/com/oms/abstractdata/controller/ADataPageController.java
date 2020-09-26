package com.oms.abstractdata.controller;

import java.util.List;
import java.util.Map;

import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.media.gui.MediaSearchPane;
import com.oms.media.gui.MediaSingleViewPane;

public abstract class ADataPageController<T> {
	private MediaSearchPane searchPane;
	private ADataListViewPane<T> listViewPane;
	
	public ADataPageController() {
		searchPane = createSearchPane();
		
		searchPane.setController(new ADataSearchController() {
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

	public ADataListViewPane<T> getListViewPane() {
		return listViewPane;
	}
	
	
	
	public abstract MediaSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract MediaSingleViewPane createSingleViewPane();
	
	public abstract ADataListViewPane<T> createListViewPane();
}
