package com.isamm.store;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isamm.store.metier.UserBoutiqueMetier;

@Controller
public class HomeController {

	@Autowired
	private UserBoutiqueMetier userMetier;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("title", "Home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		System.out.println(name);

		return "home";
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {

		model.addAttribute("title", "404 not found");

		return "404";
	}

}
