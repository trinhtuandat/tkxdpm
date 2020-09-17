package com.oms.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.search.MediaSearchPane;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin() {
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		MediaSearchPane mediaSearchPane = new MediaSearchPane();
		cp.add(mediaSearchPane, BorderLayout.NORTH);

		
		Book b = new Book();
		b.setCategory("IT");
		b.setTitle("DATTT");
		b.addAuthor("NVD");
		b.addAuthor("NVA");
		Media m = new Media("Sach IT", "IT", 54000);
		ArrayList<Media> list = new ArrayList<Media>();
		list.add(b);
		list.add(m);
		
		
		ListDataVisualizationPane dataVisualizationPane = new ListDataVisualizationPane(list);
		dataVisualizationPane.visualize();
		cp.add(dataVisualizationPane);
//
//		JScrollPane scrollPane = new JScrollPane(dataVisualizationPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
//		scrollPane.setPreferredSize(new Dimension(300, 300));
//
//		cp.add(scrollPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("......");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Run GUI codes in the Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OMSAdmin(); // Let the constructor do the job
			}
		});
	}
}