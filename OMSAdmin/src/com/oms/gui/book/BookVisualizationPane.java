package com.oms.gui.book;

import javax.swing.JLabel;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.media.PhysicalMediaVisualizationPane;

@SuppressWarnings("serial")
public class BookVisualizationPane extends PhysicalMediaVisualizationPane {
	private JLabel labelPublisher;
	private JLabel labelPublicationDate;
	private JLabel labelAuthors;
	private JLabel labelNumberOfPages;
	private JLabel labelLanguage;
	
	public BookVisualizationPane() {
		super();
		
		labelPublisher = new JLabel();
		add(labelPublisher);
		
		labelPublicationDate = new JLabel();
		add(labelPublicationDate);
		
		labelAuthors = new JLabel();
		add(labelAuthors);
		
		labelNumberOfPages = new JLabel();
		add(labelNumberOfPages);
		
		labelLanguage = new JLabel();
		add(labelLanguage);
	}
	
	public BookVisualizationPane(Media media) {
		this();
		this.t = media;

		displayData();
	}
	
	@Override
	public void displayData() {
		super.displayData();
		
		if (t instanceof Book) {
			Book book = (Book) t;
			
			labelPublisher.setText("Publisher: " + book.getPublisher());
			labelPublicationDate.setText("Publication date: " + book.getPublicationDate());
			labelAuthors.setText("Authors: " + book.getAuthors().toString());
			labelNumberOfPages.setText("Number Of Pages: " + book.getNumberOfPages());
			labelLanguage.setText("Language: " + book.getLanguage());
		}
	}
}
