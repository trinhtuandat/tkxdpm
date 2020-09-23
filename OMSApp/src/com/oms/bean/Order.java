package com.oms.bean;

import java.util.*;

public class Order<T> {
	private String id;
	private String code;
	private String customerName;
	private String customerPhoneNumber;
	private String customerAddress;
	private ArrayList<OrderItem<T>> items;
	private float totalCost;
	
	public Order() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public ArrayList<OrderItem<T>> getItems() {
		return items;
	}

	public void setItems(ArrayList<OrderItem<T>> items) {
		this.items = items;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getTotalCost() {
		float res = 0;
		if (items!= null) {
			Media mediaItem;
			Iterator<OrderItem<T>> iter = items.iterator();
			while (iter.hasNext()) {
				OrderItem<T> oi = iter.next();
				mediaItem = (Media) (oi.getItem());
				res += mediaItem.getCost() * oi.getQuantity();
			}
		}
		return res;
	}
	

	public boolean search(Order<T> order) {
		if (this.id != null && !this.id.equals("") && !this.id.contains(order.id)) {
			return false;
		}
		if (this.code != null && !this.code.equals("") && !this.code.contains(order.code)) {
			return false;
		}
		if (this.customerName != null && !this.customerName.equals("") && !this.customerName.contains(order.customerName)) {
			return false;
		}
		if (this.totalCost != 0 && this.totalCost != order.totalCost) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			return this.code.equals(((Order<T>) obj).code);
		}
		return false;
	}
}