package com.isamm.store.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.store.entities.Article;
import com.isamm.store.entities.Boutique;
import com.isamm.store.entities.Categorie;
import com.isamm.store.entities.Commande;
import com.isamm.store.entities.LigneCommande;
import com.isamm.store.entities.Panier;
import com.isamm.store.entities.User;

public class BoutiqueDAOImpl implements IBoutiqueDao {
	@PersistenceContext
	private EntityManager em;

	/* CATEGORIE */

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		return em.createQuery("select c from Categorie c").getResultList();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		return em.find(Categorie.class, idC);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		Categorie c = getCategorie(idCat);
		em.remove(c);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);

	}

	/* ARTICLE */

	@Override
	public Long ajouterArticle(Article a, Long IdCat) {
		a.setCategorie(getCategorie(IdCat));
		em.persist(a);
		return a.getIdArticle();
	}

	@Override
	public List<Article> listArticles() {
		return em.createQuery("from Article").getResultList();
	}

	@Override
	public List<Article> listArticlesParMc(String mc) {
		Query query = em.createQuery("select a from Article a where a.designation like :x or description like :x");
		query.setParameter("x", "%" + mc + "%");
		return query.getResultList();
	}

	@Override
	public List<Article> listArticlesSelectionne() {
		return em.createQuery("select a from Article a where  a.selectionne = true").getResultList();

	}

	@Override
	public List<Article> listArticlesParCategorie(Long idCat) {
		Query q = em.createQuery("select a from Article a where  a.idCategorie = :x");
		q.setParameter("x", idCat);
		return q.getResultList();
	}

	@Override
	public Article getArticle(Long idArt) {
		return em.find(Article.class, idArt);
	}

	@Override
	public void supprimerArticle(Long idArt) {
		em.remove(getArticle(idArt));

	}

	@Override
	public void modifierArticle(Article a) {
		em.merge(a);

	}

	/* BOUTIQUE */

	@Override
	public Long ajouterBoutique(Boutique b, Long IdUser) {
		b.setUser(getUser(IdUser));
		em.persist(b);
		return b.getIdBoutique();
	}

	@Override
	public void supprimerBoutique(Long idBoutique) {
		em.remove(getBoutiqueParId(idBoutique));

	}

	@Override
	public void modifierBoutique(Boutique b) {
		em.merge(b);

	}

	@Override
	public Boutique getBoutiqueParId(Long idBoutique) {
		return em.find(Boutique.class, idBoutique);
	}

	@Override
	public Boutique getBoutiqueParNom(String nomBoutique) {
		return em.find(Boutique.class, nomBoutique);
	}

	@Override
	public List<Boutique> listBoutiques() {
		return em.createQuery("from Boutique").getResultList();
	}

	/* COMMANDE */
	@Override
	public Commande enregistrerCommande(Panier p, User u) {

		em.persist(u);
		Commande cmd = new Commande();
		cmd.setUser(u);
		cmd.setLignes(p.getCommandes());
		cmd.setDateCommande(new Date());
		for (LigneCommande lc : p.getCommandes())
			em.persist(lc);
		em.persist(u);
		return cmd;
	}

	/* USER */

	@Override
	public Long ajouterUser(User u) {
		em.persist(u);
		return u.getIdUser();
	}

	@Override
	public void supprimerUser(Long idUser) {
		em.remove(getUser(idUser));

	}

	@Override
	public void modifierUser(User u) {
		em.merge(u);

	}

	@Override
	public User getUser(Long idUser) {
		return em.find(User.class, idUser);
	}

}
