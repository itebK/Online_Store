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
import com.isamm.store.entities.FavorisArticleUser;
import com.isamm.store.entities.FavorisArticleUser.Id;
import com.isamm.store.entities.LigneCommande;
import com.isamm.store.entities.Panier;
import com.isamm.store.entities.PanierArticleUser;
import com.isamm.store.entities.PanierArticleUser.IdP;
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

	@Override
	public Categorie getCategorieParNom(String catNom) {
		return (Categorie) em.createQuery("select c from Categorie c where c.nomCategorie like :x")
				.setParameter("x", catNom).getSingleResult();
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
	public List<Article> getArticleParMc(String mc) {

		return em.createQuery("select a from Article a where a.designation like :mc").setParameter("mc", "%" + mc + "%")
				.getResultList();

	}

	@Override
	public List<Article> listArticlesParCategorie(Long idCat) {
		Query q = em.createQuery("select a from Article a where  a.categorie.idCategorie = :x");
		q.setParameter("x", idCat);
		return q.getResultList();
	}

	@Override
	public List<Article> listArticlesParPrix(double min, double max) {
		Query q = em.createQuery("select a from Article a where  a.prix BETWEEN :min AND :max");
		q.setParameter("min", min);
		q.setParameter("max", max);
		return q.getResultList();
	}

	@Override
	public Article getArticle(Long idArt) {
		return em.find(Article.class, idArt);
	}

	@Override
	public List<Article> getArticleParIdBoutique(Long idBout) {
		return em.createQuery("SELECT a FROM Article a WHERE a.boutique.idBoutique = :x").setParameter("x", idBout)
				.getResultList();
	}

	@Override
	public void supprimerArticle(Long idArt) {
		em.remove(getArticle(idArt));

	}

	@Override
	public void modifierArticle(Article a) {
		em.merge(a);

	}

	@Override
	public List<Article> listFavoris(Long idUser) {

		return em.createQuery("SELECT f.article FROM FavorisArticleUser f WHERE f.user.idUser like :x")
				.setParameter("x", idUser).getResultList();
	}

	@Override
	public FavorisArticleUser getFavoris(Long idUser, Long idArticle) {
		Id id = new Id(idUser, idArticle);
		return em.find(FavorisArticleUser.class, id);

	}

	@Override
	public void ajouterFavoris(Long idArticle, Long idUser) {
		Id id = new Id(idUser, idArticle);
		FavorisArticleUser o = new FavorisArticleUser();
		o.setId(id);
		em.persist(o);
	}

	@Override
	public void supprimerAllFavoris(Long idUser) {

		em.createQuery("DELETE FROM FavorisArticleUser f WHERE f.user.idUser like :x").setParameter("x", idUser)
				.executeUpdate();
	}

	@Override
	public void supprimerFavoris(Long idArticle, Long idUser) {

		Id id = new Id(idUser, idArticle);
		FavorisArticleUser o = em.find(FavorisArticleUser.class, id);
		em.remove(o);

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

	@Override
	public Boutique getBoutiqueParUser(Long idUser) {
		return (Boutique) em.createQuery("SELECT b FROM Boutique b WHERE b.user.idUser = :id")
				.setParameter("id", idUser).getSingleResult();
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

	@Override
	public User getUserParNom(String username) {
		return (User) em.createQuery("SELECT u FROM User u WHERE u.username = :x").setParameter("x", username)
				.getSingleResult();

	}
	/* PANIER */

	@Override
	public List<Article> panierArticleParUser(Long idUser) {
		return em.createQuery("SELECT p.article FROM PanierArticleUser p WHERE p.user.idUser like :x")
				.setParameter("x", idUser).getResultList();
	}

	@Override
	public void ajouterArticlePanier(Long idArticle, Long idUser) {
		IdP id = new IdP(idUser, idArticle);
		PanierArticleUser p = new PanierArticleUser();
		p.setIdP(id);
		em.persist(p);

	}

	@Override
	public void supprimerArticlePanier(Long idArticle, Long idUser) {
		IdP id = new IdP(idUser, idArticle);
		PanierArticleUser p = em.find(PanierArticleUser.class, id);
		em.remove(p);

	}

	@Override
	public void viderPanier(Long idUser) {
		em.createQuery("DELETE FROM PanierArticleUser p WHERE p.user.idUser like :x").setParameter("x", idUser)
				.executeUpdate();

	}

}
