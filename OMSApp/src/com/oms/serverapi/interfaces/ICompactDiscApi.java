package com.oms.serverapi.interfaces;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.CompactDisc;

public interface ICompactDiscApi {
	public ArrayList<CompactDisc> getCds(Map<String, String> queryStrings);
}
