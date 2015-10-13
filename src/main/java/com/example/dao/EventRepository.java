package com.example.dao;

import com.example.domain.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by daiLlew on 30/09/2015.
 */
public interface EventRepository extends CrudRepository<Event, Long> {

	Set<Event> findByVenue(String venue);

	Set<Event> findByCity(String city);

}
