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
	@JoinColumn(name = "idVendeur")
	private Vendeur vendeur;

	public Boutique(Long idBoutique, String nomBoutique, Collection<Article> articles) {
		super();
		this.idBoutique = idBoutique;
		this.nomBoutique = nomBoutique;
		this.articles = articles;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Boutique() {
		super();

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

}
