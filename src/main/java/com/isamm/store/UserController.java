package com.isamm.store;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.isamm.store.entities.Role;
import com.isamm.store.entities.User;
import com.isamm.store.metier.UserBoutiqueMetier;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserBoutiqueMetier userMetier;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/saveUser")
	public String saveUser(@Valid User u, BindingResult bindingResult, Model model) throws IOException {

		model.addAttribute("title", "Login");

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", u);
			model.addAttribute("message", "User is not saved");
			return "login";
		}
		System.out.println(u.getEmail());
		if (u.getIdUser() == null) {
			if (u.getRoles().iterator().next().getNomRole().equals("VENDEUR_ROLE")) {
				Role role = new Role();
				role.setNomRole("CLIENT_ROLE");
				role.setUser(u);
				u.getRoles().add(role);
			}
		}

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(u.getPassword().getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			u.setPassword(sb.toString());
		} catch (NoSuchAlgorithmException ex) {
		}
		if (u.getIdUser() != null) {
			userMetier.modifierUser(u);
		} else {
			userMetier.ajouterUser(u);
		}

		model.addAttribute("title", "Login");
		model.addAttribute("message", "User is saved");

		return "login";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout";
	}

	/* PROFILE */

	@RequestMapping(value = "/profile")
	public String profile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = userMetier.getUserParNom(auth.getName());
		model.addAttribute("user", u);
		model.addAttribute("title", "Profile");
		return "profile";
	}

	@RequestMapping(value = "/profile-wishlist")
	public String wishlist(Locale locale, Model model) {

		model.addAttribute("title", "Profile-wishlist");
		return "profile-wishlist";
	}

	@RequestMapping(value = "/profile-orders")
	public String order(Locale locale, Model model) {

		model.addAttribute("title", "Profile-orders");
		return "profile-orders";
	}

	@RequestMapping(value = "/profile-address")
	public String address(Locale locale, Model model) {

		model.addAttribute("title", "Profile-address");
		return "profile-address";
	}

	@RequestMapping(value = "/profile-cart")
	public String cart(Locale locale, Model model) {

		model.addAttribute("title", "Profile-cart");
		return "profile-cart";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}