package com.oms.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.media.Book;
import com.oms.gui.search.MediaSearchPane;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin() {
		JPanel rootPanel = new JPanel();
		SpringLayout layout = new SpringLayout();
		rootPanel.setLayout(layout);
		rootPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		setContentPane(rootPanel);
		
		
		
		
		MediaSearchPane mediaSearchPane = new MediaSearchPane();
		mediaSearchPane.setPreferredSize(new Dimension(-1, 100));
		rootPanel.add(mediaSearchPane);
		mediaSearchPane.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		
		
		ArrayList<Book> list = JerseyMediaApi.singleton().getBooks(null);
		ListDataVisualizationPane dataVisualizationPane = new ListDataVisualizationPane(list);
		dataVisualizationPane.visualize();
		rootPanel.add(dataVisualizationPane);
		dataVisualizationPane.setBorder(BorderFactory.createLineBorder(Color.red));
		
		
		layout.putConstraint(SpringLayout.WEST, mediaSearchPane, 5, SpringLayout.WEST, rootPanel);
		layout.putConstraint(SpringLayout.NORTH, mediaSearchPane, 5, SpringLayout.NORTH, rootPanel);
		layout.putConstraint(SpringLayout.EAST, mediaSearchPane, -5, SpringLayout.EAST, rootPanel);
		
		layout.putConstraint(SpringLayout.WEST, dataVisualizationPane, 5, SpringLayout.WEST, rootPanel);
		layout.putConstraint(SpringLayout.NORTH, dataVisualizationPane, 5, SpringLayout.SOUTH, mediaSearchPane);
		layout.putConstraint(SpringLayout.EAST, dataVisualizationPane, -5, SpringLayout.EAST, rootPanel);
		layout.putConstraint(SpringLayout.SOUTH, dataVisualizationPane, -5, SpringLayout.SOUTH, rootPanel);
		

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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OMSAdmin(); // Let the constructor do the job
			}
		});
	}
}