package com.oms.serverapi.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.DigitalVideoDisc;

public interface IDigitalVideoDiscApi {
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryStrings);
}
