package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.Media;

@SuppressWarnings("serial")
public class MediaVisualizationPane extends ADataVisualizationPane{

	@Override
	public void visualize(Object object) {
		if (object instanceof Media) {
			Media media = (Media) object;
			JLabel label = new JLabel("Title: " + media.getTitle());
			add(label);
			
			label = new JLabel("Category: " + media.getCategory());
			add(label);
			
			label = new JLabel("Cost: " + media.getCost() + "");
			add(label);
		}
	}
}
