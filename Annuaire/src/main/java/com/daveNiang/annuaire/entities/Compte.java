package com.daveNiang.annuaire.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="comptes",
uniqueConstraints={
	    @UniqueConstraint(columnNames = {"login"})
		})
public class Compte implements Serializable {

	private Long id_compte ;
	private String login , motdepasse ;
	private Utilisateur utilisateur;
	
	
	@Id
	@Column(name = "id_compte")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId_compte() {
		return id_compte;
	}
	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
	}
	
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="motdepasse")
	public String getMotDePasse() {
		return motdepasse;
	}
	public void setMotDePasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	@OneToOne(mappedBy="compte")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	


}
