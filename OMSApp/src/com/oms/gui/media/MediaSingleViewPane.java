package com.oms.gui.media;

import javax.swing.JLabel;

import com.oms.bean.Media;
import com.oms.gui.abstractdata.ADataSingleViewPane;

@SuppressWarnings("serial")
public class MediaSingleViewPane extends ADataSingleViewPane<Media>{
	private JLabel labelTitle;
	private JLabel labelCagegory;
	private JLabel labelCost;
	
	public MediaSingleViewPane() {
		super();

		labelTitle = new JLabel();
		add(labelTitle);
		
		labelCagegory = new JLabel();
		add(labelCagegory);
		
		labelCost = new JLabel();
		add(labelCost);
	}
	
	public MediaSingleViewPane(Media media) {
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
