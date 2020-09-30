package com.oms.bean;

public class Track implements Playable {

	private String title;
	private int length;

	public Track() {
		super();
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("ERROR: Track length is 0");
			throw (new PlayerException());
		}
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}