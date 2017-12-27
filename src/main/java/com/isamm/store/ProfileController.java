package com.isamm.store;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/profile")
	public String profile(Locale locale, Model model) {
		logger.info("Welcome Profile! The client locale is {}.", locale);

		model.addAttribute("title", "Profile");
		return "profile";
	}

	@RequestMapping(value = "/profile-wishlist")
	public String wishlist(Locale locale, Model model) {
		logger.info("Welcome Profile wishlist! The client locale is {}.", locale);

		model.addAttribute("title", "Profile-wishlist");
		return "profile-wishlist";
	}

	@RequestMapping(value = "/profile-orders")
	public String order(Locale locale, Model model) {
		logger.info("Welcome Profile orders! The client locale is {}.", locale);

		model.addAttribute("title", "Profile-orders");
		return "profile-orders";
	}

	@RequestMapping(value = "/profile-address")
	public String address(Locale locale, Model model) {
		logger.info("Welcome Profile address! The client locale is {}.", locale);

		model.addAttribute("title", "Profile-address");
		return "profile-address";
	}

	@RequestMapping(value = "/profile-cart")
	public String cart(Locale locale, Model model) {
		logger.info("Welcome Profile cart! The client locale is {}.", locale);

		model.addAttribute("title", "Profile-cart");
		return "profile-cart";
	}
}
