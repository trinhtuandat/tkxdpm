package com.oms.bean;

public class OrderItem<T> {
	private T item;
	private int quantity;
	
	public OrderItem(){
	}
	
	public OrderItem(T item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public T getItem() {
		return item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
