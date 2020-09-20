package com.oms.gui.abstractdata;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.book.BookEditDialog;
import com.oms.gui.book.BookSingleViewPane;

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

	//TODO: Factory
	@SuppressWarnings("unchecked")
	public void displayData() {
		for (T t: list) {
			
			if (t instanceof Book) {
				final ADataSingleViewPane visualizationPane = new BookSingleViewPane((Media) t);
				visualizationPane.addAction("Edit", new IDataActionListener<T>() {
					@Override
					public void onAct(T t) {
						new BookEditDialog((Book) t, new IDataActionListener<Media>() {
							@Override
							public void onAct(Media t) {
								System.out.println(t);
								Book newBook = JerseyMediaApi.singleton().updateBook((Book) t);
								visualizationPane.updateData(newBook);
							}
						});
					}
				});
				
				pane.add(visualizationPane);
				pane.add(Box.createRigidArea(new Dimension(0, 40)));
			} else if (t instanceof Media) {
			}
		}
	}
	
	public void updateData(List<T> list) {
		this.list = list;
		pane.removeAll();
		pane.revalidate();
		pane.repaint();
		displayData();
	}
}
