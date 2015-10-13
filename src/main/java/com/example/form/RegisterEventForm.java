package com.example.form;

import com.example.domain.Band;

/**
 * Created by daiLlew on 12/10/2015.
 */
public class RegisterEventForm {

	private String bandName;
	private String venue;
	private String city;
	private String date;
	private boolean registerNewBand = false;
	private Band newBand = new Band();

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public boolean isRegisterNewBand() {
		return registerNewBand;
	}

	public void setRegisterNewBand(boolean registerNewBand) {
		this.registerNewBand = registerNewBand;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Band getNewBand() {
		return newBand;
	}

	public void setNewBand(Band newBand) {
		this.newBand = newBand;
	}

	@Override
	public String toString() {
		return "RegisterEventForm{" +
				"bandName=" + bandName +
				", venue='" + venue + '\'' +
				", city='" + city + '\'' +
				", date='" + date + '\'' +
				", registerNewBand=" + registerNewBand +
				'}';
	}
}
