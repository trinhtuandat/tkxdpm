package com.oms.gui.abstractdata;

public abstract class ADataPageFactory<T> {
	public abstract ADataPagePane<T> createDataManagePane(String type);
}
