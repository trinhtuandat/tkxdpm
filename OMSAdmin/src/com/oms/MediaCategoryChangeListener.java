package com.oms;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import com.oms.bean.media.CompactDisc;

public class MediaCategoryChangeListener implements VetoableChangeListener {

	/**
	 *  
	 */
	public MediaCategoryChangeListener() {
		super();
	}

	public void vetoableChange(PropertyChangeEvent e)
			throws PropertyVetoException {
		String oldvalue = (String) e.getOldValue();
		String newvalue = (String) e.getNewValue();
		if (e.getSource() instanceof CompactDisc) {
			System.out.println("[The " + e.getPropertyName()
					+ " of this item has been changed from " + oldvalue
					+ " to " + newvalue + " ]");
		} else {
			throw new PropertyVetoException(
					"[Sorry - the category for this media type can not be changed.]",
					e);
		}
	}

}