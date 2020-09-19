package com.oms.gui.media;

import javax.swing.JLabel;

import com.oms.bean.media.Media;
import com.oms.bean.media.PhysicalMedia;

@SuppressWarnings("serial")
public class PhysicalMediaVisualizationPane extends MediaVisualizationPane{
	private JLabel labelBarcode;
	private JLabel labelDescription;
	private JLabel labelQuantity;
	private JLabel labelWeight;
	private JLabel labelDimension;

	public PhysicalMediaVisualizationPane(Media media) {
		super(media);

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
	
	@Override
	public void visualize() {
		super.visualize();
		
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
