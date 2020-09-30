package com.oms.components.media.controller;

import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.gui.ADataListViewPane;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.gui.UserMediaListViewPane;

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
		return new UserMediaListViewPane(this);
	}
	
	public void addToCart(OrderItem orderItem) {
		cartController.addOrderItem(orderItem);
	}
}
