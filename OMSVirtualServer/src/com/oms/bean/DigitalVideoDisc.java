package com.oms.bean;

public class DigitalVideoDisc extends PhysicalMedia implements Playable {

	private String director;
	private String studio;
	private  String language;
	private int length;

	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public DigitalVideoDisc(String id, String title, String category, float cost, String barcode, String description, int quantity, float weight, Dimension dimension, String director, String studio, String language, int length) {
		super(id, title, category, cost, barcode, description, quantity, weight, dimension);
		
		this.director = director;
		this.studio = studio;
		this.language = language;
		this.length = length;
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
	
	@Override
	public boolean match(Media media) {
		if (media == null)
			return true;
		
		
		boolean res = super.match(media);
		if (!res) {
			return false;
		}
		
		
		if (!(media instanceof DigitalVideoDisc))
			return false;
		DigitalVideoDisc dvd = (DigitalVideoDisc) media;
		
		if (dvd.director != null && !dvd.director.equals("") && !this.director.contains(dvd.director)) {
			return false;
		}
		if (dvd.studio != null && !dvd.studio.equals("") && !this.studio.contains(dvd.studio)) {
			return false;
		}
		if (dvd.length != 0 && this.length != dvd.length) {
			return false;
		}
		if (dvd.language != null && !this.language.equals(dvd.language)) {
			return false;
		}
		return true;
	}
}