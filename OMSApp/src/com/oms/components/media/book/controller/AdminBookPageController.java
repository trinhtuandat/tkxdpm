package com.oms.components.media.book.controller;

import java.util.List;
import java.util.Map;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSingleViewPane;
import com.oms.components.media.controller.AdminMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSingleViewPane;
import com.oms.serverapi.JerseyMediaApi;

public class AdminBookPageController extends AdminMediaPageController{
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
	
	@Override
	public Media updateMedia(Media media) {
		return JerseyMediaApi.singleton().updateBook((Book) media);
	}
}
