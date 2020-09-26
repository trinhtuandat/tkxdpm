package com.oms.gui.page;

import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataPagePane;

@SuppressWarnings("serial")
public class MediaPagePane extends ADataPagePane<Media> {
	public MediaPagePane(MediaPageController controller) {
		super(controller.getSearchPane(), controller.getListViewPane());
	}
}
