package com.isamm.store;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.Boutique;
import com.isamm.store.entities.Categorie;
import com.isamm.store.metier.UserBoutiqueMetier;

@Controller
@RequestMapping(value = "/vendeur")
public class VendeurController {
	@Autowired
	private UserBoutiqueMetier userMetier;

	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public String categorie(Locale locale, Model model) {
		model.addAttribute("categorie", new Categorie());
		return "category-add";
	}

	@RequestMapping(value = "/add-article", method = RequestMethod.GET)
	public String article(Locale locale, Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("categories", userMetier.listCategories());
		return "product-add";
	}

	@RequestMapping(value = "/add-boutique", method = RequestMethod.GET)
	public String boutique(Locale locale, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		// model.addAttribute("boutique", new Boutique());

		try {
			model.addAttribute("boutiques",
					userMetier.getBoutiqueParUser(userMetier.getUserParNom(nameVendeur).getIdUser()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "boutique-add";
	}

	/* AJOUTER CATEGORIE */
	@RequestMapping(value = "/saveCat")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", userMetier.listCategories());
			return ("category-add");
		}
		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		if (c.getIdCategorie() != null) {
			if (file.isEmpty()) {
				Categorie cat = userMetier.getCategorie(c.getIdCategorie());
				c.setPhoto(cat.getPhoto());
			}
			userMetier.modifierCategorie(c);
		} else
			userMetier.ajouterCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", userMetier.listCategories());
		return "home";
	}

	/* AJOUTER ARTICLE */
	@RequestMapping(value = "/saveArt")
	public String saveArticle(@Valid Article a, BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("articles", userMetier.listArticles());
			return ("product-add");
		}
		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			a.setPhoto(file.getBytes());

		}
		if (a.getIdArticle() != null) {
			if (file.isEmpty()) {
				Article cat = userMetier.getArticle(a.getIdArticle());
				a.setPhoto(cat.getPhoto());
			}
			userMetier.modifierArticle(a);
		} else
			userMetier.ajouterArticle(a, a.getCategorie().getIdCategorie());
		model.addAttribute("article", new Article());
		model.addAttribute("articles", userMetier.listArticles());
		return "home";
	}

	/* AJOUTER BOUTIQUE */
	@RequestMapping(value = "/saveBout")
	public String saveBoutique(@Valid Boutique b, BindingResult bindingResult, Model model) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		System.out.println(nameVendeur);
		System.out.println(userMetier.getUserParNom(nameVendeur));
		if (bindingResult.hasErrors()) {
			model.addAttribute("boutiques", userMetier.listBoutiques());
			return ("boutique-add");
		} else

			userMetier.ajouterBoutique(b, userMetier.getUserParNom(nameVendeur).getIdUser());
		model.addAttribute("boutique", new Boutique());
		// model.addAttribute("articles", userMetier.listArticles());
		return "home";
	}

}