package com.isamm.store.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	// private User user;

	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> lignes;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Collection<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Commande() {
		super();
	}

}
