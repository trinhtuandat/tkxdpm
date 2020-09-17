package com.oms.service;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;

@Path("/medias")
public class MediaService {

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Media> getAllMedias(@PathParam("param") String name) {
    	ArrayList<Media> res = new ArrayList<Media>();
    	res.add(new Media("Book 1", "IT", 45000));
    	res.add(new Media("Book 2", "IT", 55000));
    	res.add(new Media("Book 3", "IT", 65000));
        return res;
    }
    
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Media getMedia(@PathParam("param") String name) {
//    	Book b = new Book();
//    	b.setCategory("IT");
//    	b.setTitle("DATTT");
//    	b.addAuthor("NVD");
//    	b.addAuthor("NVA");
        return new Media(name, "IT", 45000);
//    	return b;
    }
}