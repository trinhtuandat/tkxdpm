package com.oms.api;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.oms.bean.media.Book;
import com.oms.bean.media.Media;

public class ApiConnector {
	public ArrayList<Media> getAllMedias() {
		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
		WebTarget webTarget = client.target("http://localhost:8080/medias");// .path("medias");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Media> res = response.readEntity(new GenericType<ArrayList<Media>>(){});
		for (Media media : res) {
			System.out.println(res);
		}
		return res;
	}

	public Media getMedia() {
		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
		WebTarget webTarget = client.target("http://localhost:8080/medias/DatTT");// .path("medias");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		System.out.println(response);

		Media res = response.readEntity(Media.class);
		System.out.println(res.getTitle() + " " + res.getCategory());
		if (res instanceof Book) {
			 System.out.println(((Book) res).getAuthors());
		}
		return res;
	}

	public static void main(String[] args) {
		ApiConnector apiConnector = new ApiConnector();
//		apiConnector.getAllMedias();
		apiConnector.getMedia();
	}
}
