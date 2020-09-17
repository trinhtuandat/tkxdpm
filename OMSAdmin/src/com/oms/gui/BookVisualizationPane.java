package com.oms.gui;

import javax.swing.JLabel;

import com.oms.bean.media.Book;

@SuppressWarnings("serial")
public class BookVisualizationPane extends MediaVisualizationPane{
	@Override
	public void visualize(Object object) {
		super.visualize(object);
		
		if (object instanceof Book) {
			Book book = (Book) object;
			JLabel label = new JLabel(book.getAuthors().toString());
			add(label);
		}
	}
}
