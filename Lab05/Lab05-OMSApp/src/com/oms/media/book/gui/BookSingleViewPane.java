package com.oms.media.book.gui;

import javax.swing.JLabel;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.media.gui.PhysicalMediaSingleViewPane;

@SuppressWarnings("serial")
public class BookSingleViewPane extends PhysicalMediaSingleViewPane {
	private JLabel labelPublisher;
	private JLabel labelPublicationDate;
	private JLabel labelAuthors;
	private JLabel labelNumberOfPages;
	private JLabel labelLanguage;
	
	public BookSingleViewPane() {
		super();
	}
	
	public BookSingleViewPane(Media media) {
		this();
		this.t = media;

		displayData();
	}
	
	@Override
	public void buildControls() {
		super.buildControls();

		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelPublisher = new JLabel();
		add(labelPublisher, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelPublicationDate = new JLabel();
		add(labelPublicationDate, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelAuthors = new JLabel();
		add(labelAuthors, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumberOfPages = new JLabel();
		add(labelNumberOfPages, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelLanguage = new JLabel();
		add(labelLanguage, c);
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
