package com.oms.bean.media;

public class Track implements Playable, Comparable {

	private String title;

	private int length;

	/**
	 * Constructor for Track
	 */
	public Track() {
		super();
	}

	/**
	 * Returns the length.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the length.
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Sets the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("ERROR: Track length is 0");
			throw (new PlayerException());
		}
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	public int compareTo(Object obj) {
		Media media = (Media) obj;
		return (this.getTitle()).compareTo(media.getTitle());
	}
}