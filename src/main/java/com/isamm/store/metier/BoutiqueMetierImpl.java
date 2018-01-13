package com.isamm.store.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.isamm.store.dao.IBoutiqueDao;
import com.isamm.store.entities.Article;
import com.isamm.store.entities.Boutique;
import com.isamm.store.entities.Categorie;
import com.isamm.store.entities.Commande;
import com.isamm.store.entities.FavorisArticleUser;
import com.isamm.store.entities.Panier;
import com.isamm.store.entities.User;

@Transactional
public class BoutiqueMetierImpl implements UserBoutiqueMetier {

	private IBoutiqueDao dao;

	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}

	/* CATEGORIE */
	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);

	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		return dao.getCategorie(idC);
	}

	@Override
	public Categorie getCategorieParNom(String catNom) {
		return dao.getCategorieParNom(catNom);
	}

	/* ARTICLE */

	@Override
	public Long ajouterArticle(Article a, Long IdCat) {
		return dao.ajouterArticle(a, IdCat);
	}

	@Override
	public void supprimerArticle(Long idArt) {
		dao.supprimerArticle(idArt);

	}

	@Override
	public void modifierArticle(Article a) {
		dao.modifierArticle(a);

	}

	@Override
	public List<Article> listArticles() {
		return dao.listArticles();
	}

	@Override
	public List<Article> listArticlesParMc(String mc) {
		return dao.listArticlesParMc(mc);
	}

	@Override
	public List<Article> listArticlesSelectionne() {
		return dao.listArticlesSelectionne();
	}

	@Override
	public List<Article> getArticleParMc(String mc) {
		return dao.getArticleParMc(mc);
	}

	@Override
	public List<Article> listArticlesParCategorie(Long idCat) {
		return dao.listArticlesParCategorie(idCat);
	}

	@Override
	public List<Article> listArticlesParPrix(double min, double max) {
		return dao.listArticlesParPrix(min, max);
	}

	@Override
	public Article getArticle(Long idArt) {
		return dao.getArticle(idArt);
	}

	@Override
	public List<Article> getArticleParIdBoutique(Long idBout) {
		return dao.getArticleParIdBoutique(idBout);
	}

	@Override
	public List<Article> listFavoris(Long idUser) {

		return dao.listFavoris(idUser);
	}

	@Override
	public FavorisArticleUser getFavoris(Long idUser, Long idArticle) {

		return dao.getFavoris(idUser, idArticle);
	}

	@Override
	public void ajouterFavoris(Long idArticle, Long idUser) {
		dao.ajouterFavoris(idArticle, idUser);
	}

	@Override
	public void supprimerFavoris(Long idArticle, Long idUser) {
		dao.supprimerFavoris(idArticle, idUser);
	}

	@Override
	public void supprimerAllFavoris(Long idUser) {
		dao.supprimerAllFavoris(idUser);

	}

	/* BOUTIQUE */

	@Override
	public Long ajouterBoutique(Boutique b, Long IdVend) {
		return dao.ajouterBoutique(b, IdVend);
	}

	@Override
	public void supprimerBoutique(Long idBoutique) {
		dao.supprimerBoutique(idBoutique);

	}

	@Override
	public void modifierBoutique(Boutique b) {
		dao.modifierBoutique(b);

	}

	@Override
	public Boutique getBoutiqueParId(Long idBoutique) {
		return dao.getBoutiqueParId(idBoutique);
	}

	@Override
	public Boutique getBoutiqueParNom(String nomBoutique) {
		return dao.getBoutiqueParNom(nomBoutique);
	}

	@Override
	public List<Boutique> listBoutiques() {
		return dao.listBoutiques();
	}

	@Override
	public Commande enregistrerCommande(Panier p, User c) {
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Boutique getBoutiqueParUser(Long idUser) {
		return dao.getBoutiqueParUser(idUser);
	}

	/* USER */
	@Override
	public Long ajouterUser(User u) {

		return dao.ajouterUser(u);
	}

	@Override
	public void supprimerUser(Long idUser) {
		dao.supprimerUser(idUser);

	}

	@Override
	public void modifierUser(User u) {
		dao.modifierUser(u);

	}

	@Override
	public User getUser(Long idUser) {
		return dao.getUser(idUser);
	}

	@Override
	public User getUserParNom(String username) {
		return dao.getUserParNom(username);
	}

	/* PANIER */

	@Override
	public List<Article> panierArticleParUser(Long idUser) {
		return dao.panierArticleParUser(idUser);
	}

	@Override
	public void ajouterArticlePanier(Long idArticle, Long idUser) {
		dao.ajouterArticlePanier(idArticle, idUser);

	}

	@Override
	public void supprimerArticlePanier(Long idArticle, Long idUser) {
		dao.supprimerArticlePanier(idArticle, idUser);

	}

	@Override
	public void viderPanier(Long idUser) {
		dao.viderPanier(idUser);

	}

}
