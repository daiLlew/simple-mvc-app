package com.example.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by daiLlew on 12/10/2015.
 */
@Entity
public class Band {

	@Id
	@Column(name = "band_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "bands")
	private Set<Event> events;

	public Band() {}

	public Band(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Band{" +
				"id=" + id +
				", name='" + name + '\'' +
				", events=" + events +
				'}';
	}
}
