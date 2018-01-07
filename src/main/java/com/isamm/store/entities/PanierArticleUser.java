package com.isamm.store.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PanierArticleUser {

	// **************************** les attributs ***********************
	@Embeddable
	public static class IdP implements Serializable {
		@Column(name = "idUser")
		private Long idUser;
		@Column(name = "idArticle")
		private Long idArticle;

		public IdP() {
		}

		public IdP(Long idUser, Long idArticle) {
			super();
			this.idUser = idUser;
			this.idArticle = idArticle;
		}
	}

	@EmbeddedId
	private IdP id = new IdP();

	@ManyToOne
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idArticle", insertable = false, updatable = false)
	private Article article;
	private int quantite;

	public PanierArticleUser(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}

	public PanierArticleUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdP getIdP() {
		return id;
	}

	public void setIdP(IdP id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	// *************************** constructeur par defaut
	// ********************************

}