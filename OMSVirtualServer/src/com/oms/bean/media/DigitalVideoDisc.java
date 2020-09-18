package com.oms.bean.media;

public class DigitalVideoDisc extends PhysicalMedia implements Playable {

	private String director;
	private String studio;
	private  String language;
	private int length;

	public DigitalVideoDisc() {
		super();
	}
	
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("ERROR: DVD length is 0");
			throw (new PlayerException());
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}