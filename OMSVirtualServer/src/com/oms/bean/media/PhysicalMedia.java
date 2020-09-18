package com.oms.bean.media;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = CompactDisc.class, name = "disc"), @Type(value = DigitalVideoDisc.class, name = "dvd"), @Type(value = Book.class, name = "book")})
public class PhysicalMedia extends Media{
	private String barcode;
	private String description;
	private int quantity;
	private float weight;
	private Dimension dimension;
	
	public PhysicalMedia() {
	}
	
	public PhysicalMedia(String barcode, String description, int quantity, float weight, Dimension dimension) {
		super();
		this.barcode = barcode;
		this.description = description;
		this.quantity = quantity;
		this.weight = weight;
		this.dimension = dimension;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", barcode: " + barcode + ", description: " + description + ", quantity: " + quantity + ", weight: " + weight + ", dimension: " + dimension;
	}
}