package com.isamm.store;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/single-product")
	public String single(Locale locale, Model model) {
		logger.info("Welcome Single product! The client locale is {}.", locale);

		model.addAttribute("title", "Single product");
		return "single-product";
	}

	@RequestMapping(value = "/category-product")
	public String categorie(Locale locale, Model model) {
		logger.info("Welcome Categorie product! The client locale is {}.", locale);

		model.addAttribute("title", "Category product");
		return "category-product";
	}

	@RequestMapping(value = "/search-product")
	public String search(Locale locale, Model model) {
		logger.info("Welcome Search product! The client locale is {}.", locale);

		model.addAttribute("title", "Search product");
		return "search-product";
	}

	@RequestMapping(value = "/product-by-category")
	public String byCategory(Locale locale, Model model) {
		logger.info("Welcome Product by category! The client locale is {}.", locale);

		model.addAttribute("title", "Product by category");
		return "product-by-category";
	}
}
