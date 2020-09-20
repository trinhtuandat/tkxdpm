package com.oms.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import com.oms.gui.media.factory.MediaPageFactory;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin() {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		
		JPanel bookPage = MediaPageFactory.singleton().createDataManagePane("book");
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Books", null, bookPage, "Books");
		tabbedPane.addTab("Compact Discs", null, new JPanel(), "Compact Discs");
		tabbedPane.addTab("Digital Video Discs", null, new JPanel(), "Digital Video Discs");
		
		
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Online Media System for Administrator");
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