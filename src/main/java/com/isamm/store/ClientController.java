package com.isamm.store;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.Categorie;
import com.isamm.store.metier.UserBoutiqueMetier;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
	@Autowired
	private UserBoutiqueMetier userMetier;

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	/* ARTICLE */
	@RequestMapping(value = "/single-product")
	public String single(Locale locale, Model model, Long idArt) {
		model.addAttribute("article", userMetier.getArticle(idArt));
		model.addAttribute("title", "Single product");

		logger.info("afficher un produit spécifique");
		return "single-product";
	}

	@RequestMapping(value = "/category-product")
	public String categorie(Locale locale, Model model) {
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("title", "Category product");

		logger.info("afficher les categories");
		return "category-product";
	}

	/*
	 * @RequestMapping(value = "/search-product") public String search(Locale
	 * locale, Model model) {
	 * 
	 * logger.info("chercher produit");
	 * 
	 * model.addAttribute("title", "Search product"); return "search-product"; }
	 */

	@RequestMapping(value = "/product-by-category")
	public String articleByCategorie(Locale locale, Model model, long idCat) {

		model.addAttribute("articles", userMetier.listArticlesParCategorie(idCat));
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("title", "Product by category");

		logger.info("afficher produit d'une categorie");

		return "product-by-category";
	}

	@RequestMapping(value = "/products")
	public String articles(Locale locale, Model model) {

		model.addAttribute("articles", userMetier.listArticles());
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("title", "Products");

		logger.info("afficher articles");

		return "product-by-category";
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

}