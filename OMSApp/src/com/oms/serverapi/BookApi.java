package com.oms.serverapi;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.Book;
import com.oms.serverapi.interfaces.IBookApi;

public class BookApi implements IBookApi{
	private String rootPath = MediaApi.PATH;

	private static IBookApi singleton = new BookApi();
	public static IBookApi singleton() {
		return singleton;
	}
	
	private BookApi() {
	}
	
	@Override
	public ArrayList<Book> getBooks(Map<String, String> queryParams) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(rootPath).path("books");
		
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Book> res = response.readEntity(new GenericType<ArrayList<Book>>() {});
		System.out.println(res);
		return res;
	}
	

	@Override
	public Book updateBook(Book book) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(rootPath).path("books").path(book.getId());
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));
		
		Book res = response.readEntity(Book.class);
		return res;
	}
}
