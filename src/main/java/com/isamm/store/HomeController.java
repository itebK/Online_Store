package com.isamm.store;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		model.addAttribute("title", "Home");

		return "home";
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {
		logger.info("Welcome 404 not found! The client locale is {}.", locale);

		model.addAttribute("title", "404 not found");

		return "404";
	}

}
