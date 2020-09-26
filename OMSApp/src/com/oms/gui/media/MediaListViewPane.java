package com.oms.gui.media;

import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataListViewPane;
import com.oms.gui.abstractdata.ADataSingleViewPane;

@SuppressWarnings("serial")
public class MediaListViewPane extends ADataListViewPane<Media>{
	@Override
	public ADataSingleViewPane<Media> createDataSingleViewPane() {
		return null;
	}
}
