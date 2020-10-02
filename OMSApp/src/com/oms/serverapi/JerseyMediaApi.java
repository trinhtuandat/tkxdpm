package com.oms.serverapi;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.Media;
import com.oms.serverapi.interfaces.IMediaApi;

public class JerseyMediaApi implements IMediaApi{
	public static final String PATH = "http://localhost:8080/";
	
	private static IMediaApi singleton = new JerseyMediaApi();
	public static IMediaApi singleton() {
		return singleton;
	}
	
	private JerseyMediaApi() {
	}
	
	@Override
	public ArrayList<Media> getAllMedias() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(PATH).path("medias");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Media> res = response.readEntity(new GenericType<ArrayList<Media>>(){});
		System.out.println(res);
		return res;
	}
}
