package com.example.controller;

import com.example.dao.UserRepository;
import com.example.domain.User;
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
 * Created by daiLlew on 30/09/2015.
 */
@Controller
public class UsersConstroller {

	private static final Logger LOG = LoggerFactory.getLogger(UsersConstroller.class);

	private static final String NEW_CUST_VIEW = "register";
	private static final String ALL_CUST_VIEW = "viewUsers";

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
		return NEW_CUST_VIEW;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, Model model) {
		LOG.info("Received User: " + user.toString());
		userRepository.save(user);
		return viewAllUsers(model);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {
		List<User> users = new ArrayList<>();
		users.addAll(userRepository.findAll());
		model.addAttribute("users", users);
		return ALL_CUST_VIEW;
	}
}
