package com.oms.media.book.controller;

import java.util.List;
import java.util.Map;

import com.oms.api.JerseyMediaApi;
import com.oms.bean.Media;
import com.oms.cart.controller.CartController;
import com.oms.media.book.gui.BookSearchPane;
import com.oms.media.book.gui.BookSingleViewPane;
import com.oms.media.controller.UserMediaPageController;
import com.oms.media.gui.MediaSearchPane;
import com.oms.media.gui.MediaSingleViewPane;

public class UserBookPageController extends UserMediaPageController{
	public UserBookPageController() {
		super();
	}
	public UserBookPageController(CartController cartController) {
		super(cartController);
	}
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
}
