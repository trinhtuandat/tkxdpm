package com.oms.api;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.media.Book;
import com.oms.bean.media.CompactDisc;
import com.oms.bean.media.DigitalVideoDisc;
import com.oms.bean.media.Media;

public interface IMediaApi {
	public ArrayList<Media> getAllMedias();
	public ArrayList<Book> getBooks(Map<String, String> queryStrings);
	public ArrayList<CompactDisc> getCds(Map<String, String> queryStrings);
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryStrings);
}
