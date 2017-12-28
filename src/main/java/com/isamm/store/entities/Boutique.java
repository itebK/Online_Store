package com.isamm.store.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Boutique implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBoutique;
	private String nomBoutique;
	@OneToMany(mappedBy = "boutique")
	private Collection<Article> articles;
	@OneToOne
	@JoinColumn(name = "idUser")
	private User user;

	public Boutique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boutique(String nomBoutique, Collection<Article> articles, User user) {
		super();
		this.nomBoutique = nomBoutique;
		this.articles = articles;
		this.user = user;
	}

	public Long getIdBoutique() {
		return idBoutique;
	}

	public void setIdBoutique(Long idBoutique) {
		this.idBoutique = idBoutique;
	}

	public String getNomBoutique() {
		return nomBoutique;
	}

	public void setNomBoutique(String nomBoutique) {
		this.nomBoutique = nomBoutique;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
