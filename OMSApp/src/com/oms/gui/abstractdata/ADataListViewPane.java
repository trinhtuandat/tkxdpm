package com.oms.gui.abstractdata;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public abstract class ADataListViewPane<T> extends JScrollPane {
	private LayoutManager layout;
	protected JPanel pane;
	protected List<T> list;

	public ADataListViewPane() {
		pane = new JPanel();
		layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		this.setViewportView(pane);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.getHorizontalScrollBar().setUnitIncrement(20);
	}
	
	public ADataListViewPane(List<T> list) {
		this();
		this.list = list;
	}

	
	public void displayData() {
		for (T t: list) {
			ADataSingleViewPane<T> visualizationPane = createDataSingleViewPane();
			visualizationPane.updateData(t);
			pane.add(visualizationPane);
			pane.add(Box.createRigidArea(new Dimension(0, 40)));
		}
	}
	
	public abstract ADataSingleViewPane<T> createDataSingleViewPane();
	
	@SuppressWarnings("unchecked")
	public void updateData(List<? extends T> list) {
		this.list = (List<T>) list;
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		displayData();
	}
}
