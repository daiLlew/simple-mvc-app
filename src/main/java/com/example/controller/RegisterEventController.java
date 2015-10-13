package com.example.controller;

import com.example.dao.BandRepository;
import com.example.dao.EventRepository;
import com.example.domain.Band;
import com.example.domain.Event;
import com.example.form.RegisterEventForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daiLlew on 12/10/2015.
 */
@Controller
public class RegisterEventController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterEventController.class);

	private static final String SELECT_BAND_VIEW = "register/newEvent";

	@Autowired
	private BandRepository bandRepository;

	@Autowired
	private EventRepository eventRepository;

	@RequestMapping("/registerEvent")
	public String selectBandView(Model model) {
		model.addAttribute("artists", bandRepository.findAll());
		model.addAttribute("form", new RegisterEventForm());
		return SELECT_BAND_VIEW;
	}

	@RequestMapping(value = "/submitEvent", method = RequestMethod.POST)
	public String registerNewEvent(@ModelAttribute RegisterEventForm form) {
		LOG.info("Saving new view = " + form.toString());

		Band band = null;
		if (form.isRegisterNewBand()) {
			LOG.info("Creating a new band...");
			band = form.getNewBand();
		} else {
			band = bandRepository.findByName(form.getBandName());
		}

		Event event = new Event();
		event.getBands().add(band);
		event.setCity(form.getCity());
		event.setVenue(form.getVenue());
		event.setDate(form.getDate());
		LOG.info("Saving : " + event.toString());
		eventRepository.save(event);
		return "redirect:events";
	}
}
