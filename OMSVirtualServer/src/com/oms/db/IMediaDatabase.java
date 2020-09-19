package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.media.Media;
import com.oms.bean.media.Order;

public interface IMediaDatabase {
	public ArrayList<Media> searchMedia(Media media);
	public Media updateMedia(Media media);
	public Media addMedia(Media media);
	public ArrayList<Order> searchOrder(Order order);
	public boolean checkOutOrder(Media media);
}
