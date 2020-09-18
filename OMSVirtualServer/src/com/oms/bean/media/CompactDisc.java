package com.oms.bean.media;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class CompactDisc extends PhysicalMedia implements Playable {

	private String artist;

	private int length;
	
	private Date dateOfIssue;

	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		super();
	}
	

	public int getLength() {
		int total = 0;
		Iterator<Track> iter = tracks.iterator();
		Track nextTrack;
		while (iter.hasNext()) {
			nextTrack = (Track) iter.next();
			total += nextTrack.getLength();
		}
		return total;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("ERROR: CD length is 0");
			throw (new PlayerException());
		}
		
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length:" + this.getLength());

		Iterator<Track> iter = tracks.iterator();
		Track nextTrack;

		while (iter.hasNext()) {
			nextTrack = (Track) iter.next();
			try {
				nextTrack.play();
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		}
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public Date getDateOfIssue() {
		return dateOfIssue;
	}


	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}


	public ArrayList<Track> getTracks() {
		return tracks;
	}


	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}


	public void setLength(int length) {
		this.length = length;
	}
}