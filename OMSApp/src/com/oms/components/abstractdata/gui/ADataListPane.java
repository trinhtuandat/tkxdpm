package com.oms.components.abstractdata.gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public abstract class ADataListPane<T> extends JScrollPane {
	private LayoutManager layout;
	protected JPanel pane;
	protected List<T> list;

	public ADataListPane() {
		pane = new JPanel();
		layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		this.setViewportView(pane);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.getHorizontalScrollBar().setUnitIncrement(20);
	}
	
	public ADataListPane(List<T> list) {
		this();
		this.list = list;
	}

	
	public void displayData() {
		for (T t: list) {
			ADataSinglePane<T> singleViewPane = createDataSingleViewPane();
			singleViewPane.updateData(t);
			pane.add(singleViewPane);
			pane.add(Box.createRigidArea(new Dimension(0, 40)));
		}
	}
	
	public abstract ADataSinglePane<T> createDataSingleViewPane();
	
	@SuppressWarnings("unchecked")
	public void updateData(List<? extends T> list) {
		this.list = (List<T>) list;
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		displayData();
	}
}
