package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.media.Media;
import com.oms.bean.media.Order;
import com.oms.db.seed.Seed;

public class JsonMediaDatabase implements IMediaDatabase{
	private static IMediaDatabase singleton = new JsonMediaDatabase();
	
	private ArrayList<Media> medias = Seed.singleton().getMedias();
	private ArrayList<Order> orders = Seed.singleton().getOrders();
	
	private JsonMediaDatabase() {
	}
	
	public static IMediaDatabase singleton() {
		return singleton;
	}

	@Override
	public ArrayList<Media> searchMedia(Media media) {
		ArrayList<Media> res = new ArrayList<Media>();
		for (Media b: medias) {
			if (b.search(media)) {
				res.add(b);
			}
		}
		return res;
	}

	@Override
	public boolean addMedia(Media media) {
		for (Media m: medias) {
			if (m.equals(media)) {
				return false;
			}
		}
		
		medias.add(media);
		return true;
	}
	
	@Override
	public boolean updateMedia(Media media) {
		for (Media m: medias) {
			if (m.equals(media)) {
				medias.remove(m);
				medias.add(media);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Order> searchOrder(Order order) {
		ArrayList<Order> res = new ArrayList<Order>();
		for (Order o: orders) {
			if (o.search(order)) {
				res.add(o);
			}
		}
		return res;
	}

	@Override
	public boolean checkOutOrder(Media media) {
		return false;
	}

}