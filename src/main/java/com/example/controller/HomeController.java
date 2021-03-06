package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by daiLlew on 29/09/2015.
 */
@Controller
public class HomeController {

	private static final String VIEW = "home";

	@RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
	public String viewHome() {
		return VIEW;
	}
}
