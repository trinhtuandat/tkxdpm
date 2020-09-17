package com.oms.bean.media;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Book.class})
public class Media {
	private String title;

	private String category = "No category";

	private float cost;

	private PropertyChangeSupport changes = new PropertyChangeSupport(this);

	private VetoableChangeSupport vetoes = new VetoableChangeSupport(this);

	/**
	 *  
	 */
	public Media() {
		super();
	}
	
	

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}



	/**
	 * Returns the category.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the cost.
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * Returns the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the category.
	 */
	public void setCategory(String category) {
		try {
			String oldCategory = new String(this.category);
			this.category = category;
			vetoes.fireVetoableChange("category", oldCategory, this.category);
		} catch (PropertyVetoException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Sets the cost.
	 */
	public void setCost(float cost) {
		this.cost = cost;
		changes.firePropertyChange("cost", cost, this.cost);
	}

	/**
	 * Sets the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void addPropertyChangeListener(PropertyChangeListener p) {
		changes.addPropertyChangeListener(p);
	}

	public void removePropertyChangeListener(PropertyChangeListener p) {
		changes.removePropertyChangeListener(p);
	}

	public void addVetoableChangeListener(VetoableChangeListener v) {
		vetoes.addVetoableChangeListener(v);
	}

	public void removeVetoableChangeListener(VetoableChangeListener v) {
		vetoes.removeVetoableChangeListener(v);
	}
}