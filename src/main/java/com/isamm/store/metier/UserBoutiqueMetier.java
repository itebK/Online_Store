package com.isamm.store.metier;

import java.util.List;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.Boutique;
import com.isamm.store.entities.Categorie;
import com.isamm.store.entities.Commande;
import com.isamm.store.entities.Panier;
import com.isamm.store.entities.User;

public interface UserBoutiqueMetier {
	/* CATEGORIE */
	public Long ajouterCategorie(Categorie c);

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idC);

	public void supprimerCategorie(Long idCat);

	public void modifierCategorie(Categorie c);

	/* ARTICLE */
	public Long ajouterArticle(Article a, Long IdCat);

	public List<Article> listArticles();

	public List<Article> listArticlesParMc(String mc);

	public List<Article> listArticlesSelectionne();

	public List<Article> listArticlesParCategorie(Long idCat);

	public Article getArticle(Long idArt);

	public void supprimerArticle(Long idArt);

	public void modifierArticle(Article a);

	/* BOUTIQUE */
	public Long ajouterBoutique(Boutique b, Long IdVend);

	public void supprimerBoutique(Long idBoutique);

	public void modifierBoutique(Boutique b);

	public Boutique getBoutiqueParId(Long idBoutique);

	public Boutique getBoutiqueParNom(String nomBoutique);

	public List<Boutique> listBoutiques();

	public Boutique getBoutiqueParUser(Long idUser);

	/* COMMANDE */
	public Commande enregistrerCommande(Panier p, User c);

	/* USER */
	public Long ajouterUser(User u);

	public void supprimerUser(Long idUser);

	public void modifierUser(User u);

	public User getUser(Long idUser);

	public User getUserParNom(String username);

}