package com.oms.gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;

@SuppressWarnings("serial")
public class ListDataVisualizationPane extends JPanel {
	private ArrayList<?> list;
	private LayoutManager layout;
	private JScrollPane scrollPane;
	private JPanel pane;

	public ListDataVisualizationPane() {
		pane = new JPanel();
		layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		scrollPane = new JScrollPane(pane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
		this.setSize(new Dimension(400, 400));
		scrollPane.setPreferredSize(new Dimension(400, 400));
	}
	
	public ListDataVisualizationPane(ArrayList<?> list) {
		this();
		this.list = list;
	}

	public void visualize() {
		// TODO: Use factory
		for (Object object: list) {
			ADataVisualizationPane visualizationPane = null;
			if (object instanceof Book) {
				visualizationPane = new BookVisualizationPane();
			} else if (object instanceof Media) {
				visualizationPane = new MediaVisualizationPane();
			}
			if (visualizationPane != null) {
				visualizationPane.visualize(object);
				pane.add(visualizationPane);
				
				
				pane.add(Box.createRigidArea(new Dimension(0, 20)));
			}
		}
	}
}
