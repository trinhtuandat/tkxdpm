package com.oms.bean;

public class OrderItem {
	private Media media;
	private int quantity;
	
	public OrderItem(){
	}
	
	public OrderItem(Media media, int quantity) {
		super();
		this.media = media;
		this.quantity = quantity;
	}

	public Media getMedia() {
		return media;
	}
	
	public void setMedia(Media media) {
		this.media = media;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
