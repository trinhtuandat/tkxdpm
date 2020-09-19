package com.oms.service;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;
import com.oms.db.IMediaDatabase;
import com.oms.db.JsonMediaDatabase;

@Path("/books")
public class BookService {
	
	private IMediaDatabase mediaDatabase;
	
	public BookService() {
		mediaDatabase = JsonMediaDatabase.singleton();
	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Media> getBooks(@QueryParam("id") String id, @QueryParam("title") String title,
			@QueryParam("category") String category, @QueryParam("publisher") String publisher) {
		Book book = new Book(id, title, category, 0);
		book.setPublisher(publisher);
		ArrayList<Media> res = mediaDatabase.searchMedia(book);
		return res;
	}
	
	@POST
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Media updateBook(@PathParam("id") String id, Book book) {
		return mediaDatabase.updateMedia(book);
	}
}