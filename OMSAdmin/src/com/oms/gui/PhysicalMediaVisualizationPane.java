package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.PhysicalMedia;

@SuppressWarnings("serial")
public class PhysicalMediaVisualizationPane extends MediaVisualizationPane{

	@Override
	public void visualize(Object object) {
		super.visualize(object);
		
		if (object instanceof PhysicalMedia) {
			PhysicalMedia pMedia = (PhysicalMedia) object;
			JLabel label = new JLabel("Barcode: " + pMedia.getBarcode());
			add(label);
			
			label = new JLabel("Description: " + pMedia.getDescription());
			add(label);
			
			label = new JLabel("Quantity: " + pMedia.getQuantity());
			add(label);
			
			label = new JLabel("Weight: " + pMedia.getWeight());
			add(label);
			
			label = new JLabel("Dimension: " + pMedia.getDimension());
			add(label);
			
		}
	}
}
