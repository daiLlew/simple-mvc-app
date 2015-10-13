package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by daiLlew on 07/10/2015.
 */
@Entity
public class Event {

	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EVENT_BANDS",
			joinColumns = { @JoinColumn(name = "event_id") },
			inverseJoinColumns = @JoinColumn(name = "band_id"))
	private Set<Band> bands = new HashSet<>();
	private String venue;
	private String city;
	private String date;

	public Event() {}

	public Event(Set<Band> bands, String venue, String city, String date) {
		this.bands = bands;
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

	public Set<Band> getBands() {
		return bands;
	}

	public void setBands(Set<Band> bands) {
		this.bands = bands;
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
				", bands='" + bands + '\'' +
				", venue='" + venue + '\'' +
				", city='" + city + '\'' +
				", date=" + date +
				'}';
	}
}
