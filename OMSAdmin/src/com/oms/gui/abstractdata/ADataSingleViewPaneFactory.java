package com.oms.gui.abstractdata;

public abstract class ADataSingleViewPaneFactory<T> {
	public abstract ADataSingleViewPane<T> createDataSingleViewPane(String type);
}
