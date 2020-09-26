package com.oms;

import java.awt.BorderLayout;

import javax.swing.*;

import com.oms.abstractdata.gui.ADataPagePane;
import com.oms.bean.Media;
import com.oms.cart.gui.CartPane;
import com.oms.media.book.controller.UserBookPageController;

@SuppressWarnings("serial")
public class OMSUser extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSUser() {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		
		CartPane cartPane = new CartPane();
		
		JPanel bookPage = new ADataPagePane<Media>(new UserBookPageController(cartPane));
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Books", null, bookPage, "Books");
		tabbedPane.addTab("Compact Discs", null, new JPanel(), "Compact Discs");
		tabbedPane.addTab("Digital Video Discs", null, new JPanel(), "Digital Video Discs");

		
		rootPanel.add(cartPane, BorderLayout.NORTH);
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Online Media System for User");
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
				new OMSUser();
			}
		});
	}
}