package com.oms.db.seed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.oms.bean.media.Media;

public class Seed {
	private ArrayList<Media> books;
	public void start() {
		ObjectMapper mapper = new ObjectMapper();
		String json = FileReader.read(getClass().getResource("./dvds.json").getPath());
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			books = mapper.readValue(json, new TypeReference<ArrayList<Media>>() { });
			for (Media b: books) {
				System.out.println(b);
				System.out.println("***");
				System.out.println(mapper.writeValueAsString(b));
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB Error!");
		}
	}

	public static void main(String[] args) {
		Seed seed = new Seed();
		seed.start();
	}
}
