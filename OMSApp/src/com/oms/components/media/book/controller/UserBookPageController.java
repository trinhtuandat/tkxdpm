package com.oms.components.media.book.controller;

import java.util.List;
import java.util.Map;

import com.oms.bean.Media;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSingleViewPane;
import com.oms.components.media.controller.UserMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSingleViewPane;
import com.oms.serverapi.BookApi;

public class UserBookPageController extends UserMediaPageController{
	public UserBookPageController() {
		super();
	}
	public UserBookPageController(CartController cartController) {
		super(cartController);
	}
	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		return BookApi.singleton().getBooks(searchParams);
	}
	@Override
	public MediaSingleViewPane createSingleViewPane() {
		return new BookSingleViewPane();
	}
	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
}
