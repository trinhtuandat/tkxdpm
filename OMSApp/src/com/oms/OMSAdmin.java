package com.oms;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.gui.media.MediaSearchPane;
import com.oms.gui.media.MediaSingleViewPane;
import com.oms.gui.media.book.BookSearchPane;
import com.oms.gui.media.book.BookSingleViewPane;
import com.oms.gui.page.AdminMediaPageController;
import com.oms.gui.page.MediaPagePane;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin() {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		
		JPanel bookPage = new MediaPagePane(new AdminMediaPageController() {
			@Override
			public List<? extends Media> searchMedias(Map<String, String> searchParams) {
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
			
			@Override
			public Media updateMedia(Media media) {
				return JerseyMediaApi.singleton().updateBook((Book) media);
			}
		});
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