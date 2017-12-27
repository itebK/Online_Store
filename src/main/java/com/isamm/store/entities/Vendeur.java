package com.isamm.store.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Vendeur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVendeur;
	@Size(min = 5, max = 20)
	private String nomVendeur;
	private String adresse;
	@Email
	private String email;
	private String tel;
	@OneToMany
	@JoinColumn(name = "idRole")
	private Collection<Role> roles;

	public Long getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(Long idVendeur) {
		this.idVendeur = idVendeur;
	}

	public String getNomVendeur() {
		return nomVendeur;
	}

	public void setNomVendeur(String nomVendeur) {
		this.nomVendeur = nomVendeur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Vendeur(Long idVendeur, String nomVendeur, String adresse, String email, String tel,
			Collection<Role> roles) {
		super();
		this.idVendeur = idVendeur;
		this.nomVendeur = nomVendeur;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.roles = roles;
	}

	public Vendeur() {
		super();
		// TODO Auto-generated constructor stub
	}

}
