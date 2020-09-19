package com.oms.db.seed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oms.bean.media.Media;
import com.oms.bean.media.Order;

public class Seed {
	private ArrayList<Media> medias;
	private ArrayList<Order> orders;
	
	private static Seed singleton = new Seed();
	
	private Seed() {
		start();
	}
	
	public static Seed singleton() {
		return singleton;
	}
	
	private void start() {
		medias = new ArrayList<Media>();
		medias.addAll(generateDataFromFile(getClass().getResource("./books.json").getPath()));
		medias.addAll(generateDataFromFile(getClass().getResource("./cds.json").getPath()));
		medias.addAll(generateDataFromFile(getClass().getResource("./dvds.json").getPath()));
		
		orders = new ArrayList<Order>();
	}
	
	private ArrayList<? extends Media> generateDataFromFile(String filePath){
		ArrayList<? extends Media> res = new ArrayList<Media>();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<Media>>() { });
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}
		
		return res;
	}

	public ArrayList<Media> getMedias() {
		return medias;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public static void main(String[] args) {
		Seed seed = new Seed();
		seed.start();
	}
}