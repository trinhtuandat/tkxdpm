package com.oms.gui.abstractdata;

import java.util.List;
import java.util.Map;

import com.oms.gui.media.MediaSearchPane;
import com.oms.gui.media.MediaSingleViewPane;

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
