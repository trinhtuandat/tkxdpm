package com.oms;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.oms.bean.media.Media;

public class MediaPriceChangeListener implements PropertyChangeListener {

	/**
	 *  
	 */
	public MediaPriceChangeListener() {
		super();
	}

	public void propertyChange(PropertyChangeEvent e) {
		float oldvalue = ((Float) e.getOldValue()).floatValue();
		float newvalue = ((Float) e.getNewValue()).floatValue();

		if (oldvalue < newvalue) {
			System.out.println("[The " + e.getPropertyName() + " of "
					+ ((Media) e.getSource()).getTitle()
					+ " has increased from $" + oldvalue + " to $" + newvalue
					+ " ]");
		} else {
			System.out.println("[The " + e.getPropertyName() + " of "
					+ ((Media) e.getSource()).getTitle()
					+ " has decreased from $" + oldvalue + " to $" + newvalue
					+ " ]");
		}
	}

}