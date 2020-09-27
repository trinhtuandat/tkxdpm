package com.oms.media.controller;

import com.oms.abstractdata.controller.ADataPageController;
import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.cart.controller.CartController;
import com.oms.media.gui.MediaListViewUserPane;

public abstract class UserMediaPageController extends ADataPageController<Media> {
	private CartController cartController;
	
	public UserMediaPageController() {
		super();
	}
	
	public UserMediaPageController(CartController cartController) {
		this();
		setCartController(cartController);
	}
	
	public void setCartController(CartController cartController) {
		this.cartController = cartController;
	}
	
	@Override
	public ADataListViewPane<Media> createListViewPane() {
		return new MediaListViewUserPane(this);
	}
	
	public void addToCart(OrderItem orderItem) {
		cartController.addOrderItem(orderItem);
	}
}
