package com.example.dao;

import com.example.domain.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by daiLlew on 30/09/2015.
 */
public interface EventRepository extends CrudRepository<Event, Long> {

	Event findByBand(String band);
}
