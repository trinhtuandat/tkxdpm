package com.oms.api;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.oms.bean.media.Media;

public class ApiConnector {
	public ArrayList<Media> getAllMedias() {
		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
		WebTarget webTarget = client.target("http://localhost:8080/medias");// .path("medias");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Media> res = response.readEntity(ArrayList.class);
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

		Media res = response.readEntity(Media.class);
		System.out.println(res.getTitle() + " " + res.getCategory());
		return res;
	}

	public static void main(String[] args) {
		ApiConnector apiConnector = new ApiConnector();
		apiConnector.getAllMedias();
		apiConnector.getMedia();
	}
}
