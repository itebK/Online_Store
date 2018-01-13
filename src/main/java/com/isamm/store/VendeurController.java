package com.isamm.store;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		model.addAttribute("title", "Add category");
		return "category-add";
	}

	@RequestMapping(value = "/add-article", method = RequestMethod.GET)
	public String addArticle(Locale locale, Model model) {

		model.addAttribute("article", new Article());
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("title", "Add article");
		return "product-add";
	}

	@RequestMapping(value = "/edit-article", method = RequestMethod.GET)
	public String editArticle(Locale locale, Model model, Long idArt) {

		model.addAttribute("article", userMetier.getArticle(idArt));
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("title", "Edit article");
		return "product-edit";
	}

	@RequestMapping(value = "/add-boutique", method = RequestMethod.GET)
	public String boutique(Locale locale, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();

		model.addAttribute("boutique", new Boutique());

		try {
			Boutique b = new Boutique();
			b = userMetier.getBoutiqueParUser(userMetier.getUserParNom(nameVendeur).getIdUser());
			model.addAttribute("boutiques", b);
			model.addAttribute("articleParBoutique", userMetier.getArticleParIdBoutique(b.getIdBoutique()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title", "Add boutique");
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
		Categorie cate = null;
		if (c.getIdCategorie() != null) {
			if (file.isEmpty()) {
				Categorie cat = userMetier.getCategorie(c.getIdCategorie());
				c.setPhoto(cat.getPhoto());
			}
			userMetier.modifierCategorie(c);
		} else
			try {
				cate = userMetier.getCategorieParNom(c.getNomCategorie());
			} catch (NoResultException e) {

			}
		if (cate == null) {
			userMetier.ajouterCategorie(c);
			model.addAttribute("message", "Category is saved");
			model.addAttribute("categorie", new Categorie());
			model.addAttribute("categories", userMetier.listCategories());

			model.addAttribute("title", "Home");

			return "home";
		} else {
			model.addAttribute("message", "Category exists");
			return "category-add";
		}

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
				Article art = userMetier.getArticle(a.getIdArticle());
				a.setPhoto(art.getPhoto());
			}

			userMetier.modifierArticle(a);

		} else

		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String nameVendeur = auth.getName();
			Boutique b = new Boutique();
			b = userMetier.getBoutiqueParUser(userMetier.getUserParNom(nameVendeur).getIdUser());
			a.setBoutique(b);

			userMetier.ajouterArticle(a, a.getCategorie().getIdCategorie());
		}
		model.addAttribute("article", new Article());
		model.addAttribute("articles", userMetier.listArticles());
		model.addAttribute("message", "Article is saved");
		model.addAttribute("title", "Home");

		return "home";
	}

	@RequestMapping(value = "/suppArt")
	public String supp(Long idArt, Model model) {
		userMetier.supprimerArticle(idArt);
		model.addAttribute("produit", new Article());
		model.addAttribute("produits", userMetier.listArticles());
		model.addAttribute("categories", userMetier.listCategories());
		return "redirect:/vendeur/add-boutique";
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
		model.addAttribute("message", "Boutique is saved");
		model.addAttribute("title", "Home");

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

}