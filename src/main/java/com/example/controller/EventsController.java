package com.example.controller;

import com.example.dao.EventRepository;
import com.example.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daiLlew on 07/10/2015.
 */
@Controller
public class EventsController {

	private static final Logger LOG = LoggerFactory.getLogger(EventsController.class);

	private static final String VIEW_EVENTS = "viewEvents";
	private static final String REGISTER_EVENT = "registerEvent";

	@Autowired
	public EventRepository eventRepository;

	/**
	 * Get the events page.
	 */
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String getEvents(Model model) {
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(event -> events.add(event));
		model.addAttribute("events", events);
		return VIEW_EVENTS;
	}

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String getEventForm(Model model) {
		model.addAttribute(new Event());
		return REGISTER_EVENT;
	}

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String submitEvent(@ModelAttribute Event event, Model model) {
		LOG.info("Received Event to save.");
		eventRepository.save(event);
		return getEvents(model);
	}
}
