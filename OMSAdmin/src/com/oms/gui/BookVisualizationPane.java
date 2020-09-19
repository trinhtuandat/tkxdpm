package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;

@SuppressWarnings("serial")
public class BookVisualizationPane extends PhysicalMediaVisualizationPane {
	private JLabel labelPublisher;
	private JLabel labelPublicationDate;
	private JLabel labelAuthors;
	private JLabel labelNumberOfPages;
	private JLabel labelLanguage;
	
	public BookVisualizationPane(Media media) {
		super(media);
		
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
	
	@Override
	public void visualize() {
		super.visualize();
		
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
