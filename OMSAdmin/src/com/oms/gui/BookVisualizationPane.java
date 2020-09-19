package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.Book;

@SuppressWarnings("serial")
public class BookVisualizationPane extends PhysicalMediaVisualizationPane {
	@Override
	public void visualize(Object object) {
		super.visualize(object);
		
		if (object instanceof Book) {
			Book book = (Book) object;
			JLabel label = new JLabel("Publisher: " + book.getPublisher());
			add(label);
			
			label = new JLabel("Publication date: " + book.getPublicationDate());
			add(label);
			
			label = new JLabel("Authors: " + book.getAuthors().toString());
			add(label);
			
			label = new JLabel("Number Of Pages: " + book.getNumberOfPages());
			add(label);
			
			label = new JLabel("Language: " + book.getLanguage());
			add(label);
		}
	}
}
