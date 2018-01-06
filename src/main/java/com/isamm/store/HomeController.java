package com.isamm.store;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.Boutique;
import com.isamm.store.entities.Categorie;
import com.isamm.store.entities.User;
import com.isamm.store.metier.UserBoutiqueMetier;

@Controller
public class HomeController {

	@Autowired
	private UserBoutiqueMetier userMetier;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("articles", userMetier.listArticles());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		model.addAttribute("boutique", new Boutique());
		model.addAttribute("title", "Home");

		try {
			model.addAttribute("boutiques", userMetier.getBoutiqueParUser(userMetier.getUserParNom(name).getIdUser()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("afficher Home");
		return "home";
	}

	/* PHOTO ARTICLE */
	@RequestMapping(value = "photoArt", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photArt(Long idArt) throws IOException {
		Article a = userMetier.getArticle(idArt);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getPhoto()));
	}

	/* PHOTO CATEGORIE */
	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Long idCat) throws IOException {
		Categorie a = userMetier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getPhoto()));
	}

	/* PHOTO PROFILE */
	@RequestMapping(value = "photoProfile", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProfile(Long idUser) throws IOException {
		User a = userMetier.getUser(idUser);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getPhoto()));
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {

		model.addAttribute("title", "404 not found");
		logger.info("page introuvable");
		return "404";
	}

}
