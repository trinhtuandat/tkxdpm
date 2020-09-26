package com.oms.media.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.oms.abstractdata.controller.ADataPageController;
import com.oms.abstractdata.gui.ADataListViewPane;
import com.oms.abstractdata.gui.ADataSingleViewPane;
import com.oms.bean.Media;
import com.oms.bean.OrderItem;
import com.oms.cart.gui.CartPane;

public abstract class UserMediaPageController extends ADataPageController<Media> {
	private CartPane cartPane;
	
	public UserMediaPageController(CartPane cartPane) {
		super();
		this.cartPane = cartPane;
	}
	
	@Override
	public ADataListViewPane<Media> createListViewPane() {
		return new ADataListViewPane<Media>() {
			private static final long serialVersionUID = 1L;

			@Override
			public ADataSingleViewPane<Media> createDataSingleViewPane() {
				ADataSingleViewPane<Media> singleView = createSingleViewPane();
				
				JSpinner spin = new JSpinner();
				spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
				singleView.addDataHandlingComponent(spin);
				spin.setPreferredSize(new Dimension(100, 20));
				
				JButton button = new JButton("Buy");
				singleView.addDataHandlingComponent(button);
				
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						cartPane.addItem(new OrderItem(singleView.getData(), (int)spin.getValue()));
					}
				});
				
				return singleView;
			}
		};
	}
	
}
