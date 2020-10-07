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

import com.oms.bean.CompactDisc;
import com.oms.serverapi.interfaces.ICompactDiscApi;

public class CompactDiscApi implements ICompactDiscApi {
	private String rootPath = MediaApi.PATH;

	private static ICompactDiscApi singleton = new CompactDiscApi();
	public static ICompactDiscApi singleton() {
		return singleton;
	}
	
	private CompactDiscApi() {
	}
	
	@Override
	public ArrayList<CompactDisc> getCds(Map<String, String> queryParams) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(rootPath).path("cds");

		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<CompactDisc> res = response.readEntity(new GenericType<ArrayList<CompactDisc>>() {});
		System.out.println(res);
		return res;
	}
}
