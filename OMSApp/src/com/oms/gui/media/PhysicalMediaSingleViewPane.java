package com.oms.gui.media;

import javax.swing.JLabel;

import com.oms.bean.Media;
import com.oms.bean.PhysicalMedia;

@SuppressWarnings("serial")
public class PhysicalMediaSingleViewPane extends MediaSingleViewPane{
	private JLabel labelBarcode;
	private JLabel labelDescription;
	private JLabel labelQuantity;
	private JLabel labelWeight;
	private JLabel labelDimension;
	
	public PhysicalMediaSingleViewPane() {
		super();

		labelBarcode = new JLabel();
		add(labelBarcode);
		
		labelDescription = new JLabel();
		add(labelDescription);
		
		labelQuantity = new JLabel();
		add(labelQuantity);
		
		labelWeight = new JLabel();
		add(labelWeight);
		
		labelDimension = new JLabel();
		add(labelDimension);
	}
	
	public PhysicalMediaSingleViewPane(Media media) {
		this();
		this.t = media;
		
		displayData();
	}
	
	@Override
	public void displayData() {
		super.displayData();
		
		if (t instanceof PhysicalMedia) {
			PhysicalMedia pMedia = (PhysicalMedia) t;
			
			labelBarcode.setText("Barcode: " + pMedia.getBarcode());
			labelDescription.setText("Description: " + pMedia.getDescription());
			labelQuantity.setText("Quantity: " + pMedia.getQuantity());
			labelWeight.setText("Weight: " + pMedia.getWeight());
			labelDimension.setText("Dimension: " + pMedia.getDimension());
		}
	}
}
