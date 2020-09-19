package com.oms.gui.book;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.gui.IDataActionListener;
import com.oms.gui.media.PhysicalMediaEditDialog;

@SuppressWarnings("serial")
public class BookEditDialog extends PhysicalMediaEditDialog{
	
	private JTextField publisherField;
	private JTextField languageField;
	
	public BookEditDialog(Media media, IDataActionListener<Media> onSaveListener) {
		super(media, onSaveListener);
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
		if (t instanceof Book) {
			Book book = (Book) t;
			
			int row = getLastRowIndex();
			JLabel publisherLabel = new JLabel("Publisher");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(publisherLabel, c);
			publisherField = new JTextField(15);
			publisherField.setText(book.getPublisher());
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(publisherField, c);
			
			
			row = getLastRowIndex();
			JLabel languageLabel = new JLabel("Language");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(languageLabel, c);
			languageField = new JTextField(15);
			languageField.setText(book.getLanguage());
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(languageField, c);
		}
	}

	@Override
	public Media getNewData() {
		super.getNewData();
		
		if (t instanceof Book) {
			Book book = (Book) t;
			
			book.setPublisher(publisherField.getText());
			book.setLanguage(languageField.getText());
		}
		
		return t;
	}
}
