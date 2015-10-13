package com.example.controller;

import com.example.common.SearchType;
import com.example.dao.BandRepository;
import com.example.dao.EventRepository;
import com.example.domain.Band;
import com.example.domain.Event;
import com.example.form.EventSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by daiLlew on 07/10/2015.
 */
@Controller
public class EventsController {

	private static final Logger LOG = LoggerFactory.getLogger(EventsController.class);

	private static final String VIEW_EVENTS = "view/events";

	@Autowired
	public EventRepository eventRepository;

	@Autowired
	private BandRepository bandRepository;

	/**
	 * Get the events page.
	 */
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String getEvents(Model model) {
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(event -> events.add(event));
		model.addAttribute("events", events);
		model.addAttribute("searchForm", new EventSearchForm());
		return VIEW_EVENTS;
	}

	@RequestMapping(value = "/events/search", method = RequestMethod.POST)
	public String searchEvents(@ModelAttribute(value = "searchForm") EventSearchForm searchForm,
	                           BindingResult bindingResult, Model model) {
		LOG.info("Search submitted " + searchForm.toString());

		Set<Event> events;

		switch(SearchType.toSearchType(searchForm.getSearchType())) {
			case SEARCH_BY_BAND_NAME:
				Band band = bandRepository.findByName(searchForm.getSearchValue());
				events = band.getEvents();
				break;
			case SEARCH_BY_VENUE_NAME:
				events = eventRepository.findByVenue(searchForm.getSearchValue());
				break;
			case SEARCH_BY_CITY_NAME:
				events = eventRepository.findByCity(searchForm.getSearchValue());
				break;
			default:
				Set<Event> temp = new HashSet<>();
				eventRepository.findAll().forEach(event -> temp.add(event));
				events = temp;
		}

		model.addAttribute("events", events);
		model.addAttribute("searchForm", new EventSearchForm());
		return VIEW_EVENTS;
	}

}
