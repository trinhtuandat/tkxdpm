package com.oms.gui.abstractdata.factory;

import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.abstractdata.IDataActionListener;

public abstract class ADataPageFactory<T, U> {
	public abstract ADataPagePane<T> createDataPagePane(String type, IDataActionListener<U> listener);
}
