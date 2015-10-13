package com.example.controller;

import com.example.dao.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by daiLlew on 12/10/2015.
 */
@Controller
public class BandController {

	private static final String VIEW_BAND = "view/band";

	@Autowired
	private BandRepository bandRepository;

	@RequestMapping(value = "/band", method = RequestMethod.GET)
	public String viewBand(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("band", bandRepository.findByName(name));
		return VIEW_BAND;
	}
}
