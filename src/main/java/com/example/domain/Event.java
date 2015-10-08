package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by daiLlew on 07/10/2015.
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String band;
	private String venue;
	private String city;
	private String date;

	public Event() {}

	public Event(String band, String venue, String city, String date) {
		this.band = band;
		this.venue = venue;
		this.city = city;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
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

	@Override
	public String toString() {
		return "Event{" +
				"id=" + id +
				", band='" + band + '\'' +
				", venue='" + venue + '\'' +
				", city='" + city + '\'' +
				", date=" + date +
				'}';
	}
}
