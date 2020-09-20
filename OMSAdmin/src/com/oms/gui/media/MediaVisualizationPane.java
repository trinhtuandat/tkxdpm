package com.oms.gui.media;

import javax.swing.JLabel;

import com.oms.bean.media.Media;
import com.oms.gui.abstractdata.ADataVisualizationPane;

@SuppressWarnings("serial")
public class MediaVisualizationPane extends ADataVisualizationPane<Media>{
	private JLabel labelTitle;
	private JLabel labelCagegory;
	private JLabel labelCost;
	
	public MediaVisualizationPane() {
		super();

		labelTitle = new JLabel();
		add(labelTitle);
		
		labelCagegory = new JLabel();
		add(labelCagegory);
		
		labelCost = new JLabel();
		add(labelCost);
	}
	
	public MediaVisualizationPane(Media media) {
		this();
		this.t = media;
		
		displayData();
	}

	@Override
	public void displayData() {
		labelTitle.setText("Title: " + t.getTitle());
		labelCagegory.setText("Category: " + t.getCategory());
		labelCost.setText("Cost: " + t.getCost() + "");
	}
}
