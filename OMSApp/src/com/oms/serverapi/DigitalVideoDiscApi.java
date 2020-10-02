package com.oms.serverapi;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.DigitalVideoDisc;
import com.oms.serverapi.interfaces.IDigitalVideoDiscApi;

public class DigitalVideoDiscApi implements IDigitalVideoDiscApi {
	private String rootPath = JerseyMediaApi.PATH;

	private static IDigitalVideoDiscApi singleton = new DigitalVideoDiscApi();
	public static IDigitalVideoDiscApi singleton() {
		return singleton;
	}
	
	private DigitalVideoDiscApi() {
	}
	
	@Override
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(rootPath).path("dvds");

		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<DigitalVideoDisc> res = response.readEntity(new GenericType<ArrayList<DigitalVideoDisc>>() {});
		System.out.println(res);
		return res;
	}
}
