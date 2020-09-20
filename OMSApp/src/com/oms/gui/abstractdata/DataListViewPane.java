package com.oms.gui.abstractdata;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.media.factory.MediaSingleViewPaneFactory;

@SuppressWarnings("serial")
public class DataListViewPane<T> extends JScrollPane {
	private List<T> list;
	private LayoutManager layout;
	private JPanel pane;

	public DataListViewPane() {
		pane = new JPanel();
		layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		this.setViewportView(pane);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.getHorizontalScrollBar().setUnitIncrement(20);
	}
	
	public DataListViewPane(List<T> list) {
		this();
		this.list = list;
	}

	
	public void displayData() {
		for (T t: list) {
			if (t instanceof Book) {
				ADataSingleViewPane<Media> visualizationPane = MediaSingleViewPaneFactory.singleton().createDataSingleViewPane("book");
				visualizationPane.updateData((Book) t);
				pane.add(visualizationPane);
				pane.add(Box.createRigidArea(new Dimension(0, 40)));
			} else if (t instanceof Media) {
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void updateData(List<? extends T> list) {
		this.list = (List<T>) list;
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		displayData();
	}
}
