package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.Media;

@SuppressWarnings("serial")
public class MediaVisualizationPane extends ADataVisualizationPane<Media>{
	private JLabel labelTitle;
	private JLabel labelCagegory;
	private JLabel labelCost;
	
	public MediaVisualizationPane(Media media) {
		super(media);

		labelTitle = new JLabel();
		add(labelTitle);
		
		labelCagegory = new JLabel();
		add(labelCagegory);
		
		labelCost = new JLabel();
		add(labelCost);
	}

	@Override
	public void visualize() {
		labelTitle.setText("Title: " + t.getTitle());
		labelCagegory.setText("Category: " + t.getCategory());
		labelCost.setText("Cost: " + t.getCost() + "");
	}
}
