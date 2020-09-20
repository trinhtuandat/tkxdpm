package com.oms.gui.abstractdata.factory;

import com.oms.gui.abstractdata.ADataSingleViewPane;

public abstract class ADataSingleViewPaneFactory<T> {
	public abstract ADataSingleViewPane<T> createDataSingleViewPane(String type);
}
