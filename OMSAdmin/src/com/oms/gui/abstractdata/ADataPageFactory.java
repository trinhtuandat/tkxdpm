package com.oms.gui.abstractdata;

public abstract class ADataPageFactory<T> {
	public abstract ADataPagePane<T> createDataManagePane(String type);
	
//	protected abstract DataListViewPane initializeDataManagePane(String type);
	
	
//	private Map<String, DataListViewPane<T>> registrator;
//	public AFactory() {
//		registrator = new HashMap<String, DataListViewPane<T>>();
//	}
//	
//	protected abstract DataListViewPane<T> createDataManagePane();
//	
//	public void register(String id, DataListViewPane<T> dataManagePane) {
//		registrator.put(id, dataManagePane );
//	}
//	
//	public DataListViewPane<T> createDataManagePane(String id){
//		return registrator.get(id).createDataManagePane();
//	}
}
