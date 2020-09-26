package com.oms;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Media;
import com.oms.cart.CartPane;
import com.oms.gui.abstractdata.ADataPagePane;
import com.oms.gui.media.MediaSearchPane;
import com.oms.gui.media.MediaSingleViewPane;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;

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
		
		JPanel bookPage = new ADataPagePane<Media>(new UserMediaPageController(cartPane) {
			@Override
			public List<? extends Media> search(Map<String, String> searchParams) {
				return JerseyMediaApi.singleton().getBooks(searchParams);
			}
			@Override
			public MediaSingleViewPane createSingleViewPane() {
				return new BookSingleViewPane();
			}
			@Override
			public MediaSearchPane createSearchPane() {
				return new BookSearchPane();
			}
		});
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
				new OMSUser(); // Let the constructor do the job
			}
		});
	}
}