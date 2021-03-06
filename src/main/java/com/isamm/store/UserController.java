package com.isamm.store;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.FavorisArticleUser;
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
			logger.warn("erreur lors d'inscription");

			return "login";
		}

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
			User userFind = null;

			try {
				userFind = userMetier.getUserParNom(u.getUsername());
			} catch (NoResultException e) {

			}
			if (userFind == null) {
				userMetier.ajouterUser(u);
				model.addAttribute("message", "User is saved");
			} else {
				model.addAttribute("message", "User is not saved : Username exists");
			}
		}

		model.addAttribute("title", "Login");

		logger.info("utilisateur inscrit avec succés");

		return "login";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", "Login");

		logger.info("afficher page login");

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		logger.info("deconnexion du compte");

		return "redirect:/login?logout";
	}

	/* PROFILE */

	@RequestMapping(value = "/profile")
	public String profile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = userMetier.getUserParNom(auth.getName());
		model.addAttribute("user", u);
		model.addAttribute("favoris", userMetier.listFavoris(u.getIdUser()));
		model.addAttribute("title", "Profile");
		logger.info("afficher profile de l'utilisateur connecter");
		model.addAttribute("favoris", userMetier.listFavoris(u.getIdUser()));
		model.addAttribute("message", "Welcome " + u.getUsername() + " to your profile");

		return "profile";
	}
	/* FAVORIS */

	@RequestMapping(value = "/profile-wishlist")
	public String wishlist(Locale locale, Model model) {

		model.addAttribute("title", "Profile-wishlist");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();

		User u = userMetier.getUserParNom(nameVendeur);

		model.addAttribute("favoris", userMetier.listFavoris(u.getIdUser()));
		logger.info("afficher liste des favoris");
		return "profile-wishlist";
	}

	@RequestMapping(value = "/add-to-wishlist")
	public String addWishlist(Long idUser, Model model, Long idArt) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);
		FavorisArticleUser favA = null;
		model.addAttribute("articles", userMetier.listArticles());
		model.addAttribute("categories", userMetier.listCategories());
		model.addAttribute("favoris", userMetier.listFavoris(u.getIdUser()));

		try {
			favA = userMetier.getFavoris(u.getIdUser(), idArt);
		} catch (NoResultException e) {

		}
		if (favA == null) {
			userMetier.ajouterFavoris(idArt, u.getIdUser());
			return "redirect:/profile-wishlist";
		} else {
			model.addAttribute("message", "Already added to wishlist");

			return "product-by-category";
		}

	}

	@RequestMapping(value = "/delete-from-wishlist")
	public String deleteWishlist(Long idUser, Model model, Long idArt) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);
		System.out.println(idArt + "/user :" + u.getIdUser());

		userMetier.supprimerFavoris(idArt, u.getIdUser());

		return "redirect:/profile-wishlist";
	}

	@RequestMapping(value = "/delete-all-wishlist")
	public String supp(Long idUser, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);

		userMetier.supprimerAllFavoris(u.getIdUser());

		return "redirect:/profile-wishlist";
	}

	/************************************************************/
	/* PANIER */
	@RequestMapping(value = "/profile-cart")
	public String cart(Locale locale, Model model) {

		model.addAttribute("title", "Profile-cart");

		logger.info("afficher liste des produits dans le panier de l'utilisateur connecter");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();

		User u = userMetier.getUserParNom(nameVendeur);

		model.addAttribute("panier", userMetier.panierArticleParUser(u.getIdUser()));

		return "profile-cart";
	}

	@RequestMapping(value = "/add-to-cart")
	public String addToCart(Long idUser, Model model, Long idArt) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);

		userMetier.ajouterArticlePanier(idArt, u.getIdUser());

		return "redirect:/profile-cart";
	}

	@RequestMapping(value = "/delete-from-cart")
	public String deleteFromCart(Long idUser, Model model, Long idArt) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);

		userMetier.supprimerArticlePanier(idArt, u.getIdUser());

		return "redirect:/profile-cart";
	}

	@RequestMapping(value = "/delete-all-cart")
	public String viderPanier(Long idUser, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nameVendeur = auth.getName();
		User u = userMetier.getUserParNom(nameVendeur);

		userMetier.viderPanier(u.getIdUser());

		return "redirect:/profile-cart";
	}

	/************************************************************/

	@RequestMapping(value = "/profile-orders")
	public String order(Locale locale, Model model) {

		model.addAttribute("title", "Profile-orders");

		logger.info("afficher historique des commandes");

		return "profile-orders";
	}

	@RequestMapping(value = "/profile-address")
	public String address(Locale locale, Model model) {

		model.addAttribute("title", "Profile-address");
		logger.info("afficher adresse de l'utilisateur connecter");
		return "profile-address";
	}

	/* AJOUTER ARTICLE */
	@RequestMapping(value = "/saveImgProfile")
	public String saveImgProfile(@Valid User a, Model model, MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			a.setPhoto(file.getBytes());
		}
		if (a.getIdUser() != null) {
			if (file.isEmpty()) {
				Article art = userMetier.getArticle(a.getIdUser());
				a.setPhoto(art.getPhoto());
			}
			userMetier.modifierUser(a);
		}

		return "redirect:/profile";

	}

	/* SEARCH ARTICLE */
	@RequestMapping(value = "/searchParMc")
	public String searchParMc(String site_search, Model model) {
		model.addAttribute("articles", userMetier.getArticleParMc(site_search));
		model.addAttribute("categories", userMetier.listCategories());
		return "product-by-category";

	}

	@RequestMapping(value = "/searchParPrix")
	public String searchParPrix(Locale locale, Model model, double min, double max) {
		model.addAttribute("min", min);
		model.addAttribute("max", max);
		model.addAttribute("articles", userMetier.listArticlesParPrix(min, max));
		model.addAttribute("categories", userMetier.listCategories());
		logger.info("prix entre" + min + "$ et " + max + "$");
		return "product-by-category";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		logger.info("accés n'est pas autoriser");
		model.setViewName("403");
		return model;

	}

	/* PHOTO ARTICLE */
	@RequestMapping(value = "photoArticle", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoArticle(Long idArt) throws IOException {
		Article a = userMetier.getArticle(idArt);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getPhoto()));
	}

}