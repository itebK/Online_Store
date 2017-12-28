package com.isamm.store.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String nomRole;

	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}

	public Role(Long idRole, String nomRole) {
		super();
		this.idRole = idRole;
		this.nomRole = nomRole;
	}

	public Role() {
		super();
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

}
