package com.oms.gui;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ADataVisualizationPane extends JPanel {
	private LayoutManager layout;

	public ADataVisualizationPane() {
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
	}
	
	public abstract void visualize(Object object);
}
