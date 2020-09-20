package com.oms.gui.abstractdata.factory;

import com.oms.gui.abstractdata.ADataPagePane;

public abstract class ADataPageFactory<T> {
	public abstract ADataPagePane<T> createDataManagePane(String type);
}
