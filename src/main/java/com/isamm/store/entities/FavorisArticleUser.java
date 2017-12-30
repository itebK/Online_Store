package com.isamm.store.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FavorisArticleUser {

	// **************************** les attributs ***********************
	@Embeddable
	public static class Id implements Serializable {
		@Column(name = "idUser")
		private Integer idUser;
		@Column(name = "idArticle")
		private Integer idArticle;

		public Id() {
		}

		public Id(Integer idUser, Integer idArticle) {
			super();
			this.idUser = idUser;
			this.idArticle = idArticle;
		}
	}

	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@JoinColumn(name = "idUser", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idArticle", insertable = false, updatable = false)
	private Article article;

	public FavorisArticleUser(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}

	public FavorisArticleUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
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

	// *************************** constructeur par defaut
	// ********************************

}