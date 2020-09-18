package com.oms.db.seed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;

public class Seed {
	private ArrayList<Media> books;
	public void start() {
		ObjectMapper mapper = new ObjectMapper();
		String json = FileReader.read(getClass().getResource("./book.json").getPath());
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			books = mapper.readValue(json, new TypeReference<ArrayList<Media>>() { });
			for (Media b: books) {
				System.out.println(b);
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
