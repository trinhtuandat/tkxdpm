package com.oms.gui.page;

import java.util.List;
import java.util.Map;

import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.ADataSearchController;
import com.oms.gui.media.MediaSearchPane;
import com.oms.gui.media.MediaSingleViewPane;

public abstract class MediaPageController {
	private MediaSearchPane searchPane;
	private ADataListViewPane<Media> listViewPane;
	
	public MediaPageController() {
		searchPane = createSearchPane();
		
		searchPane.setController(new ADataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends Media> list = searchMedias(searchParams);
				listViewPane.updateData(list);
			}
		});
		
		listViewPane = createListViewPane();
		
		searchPane.fireSearchEvent();
	}

	public MediaSearchPane getSearchPane() {
		return searchPane;
	}

	public ADataListViewPane<Media> getListViewPane() {
		return listViewPane;
	}
	
	

	
	
	public abstract MediaSearchPane createSearchPane();

	public abstract List<? extends Media> searchMedias(Map<String, String> searchParams);
	
	
	
	
	
	public abstract MediaSingleViewPane createSingleViewPane();
	
	public abstract ADataListViewPane<Media> createListViewPane();
}
