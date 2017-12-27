package com.isamm.store;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/login")
	public String login(Locale locale, Model model) {
		logger.info("Welcome Login! The client locale is {}.", locale);

		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = "/recovery-password")
	public String recovery(Locale locale, Model model) {
		logger.info("Welcome Recovery password! The client locale is {}.", locale);

		model.addAttribute("title", "Recovery password");
		return "recovery-password";
	}
}
