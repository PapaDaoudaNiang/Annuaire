package com.daveNiang.annuaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	private long id_contact;
	private String nom, prenom, num_tel, adresse, profession, email;
	private Date date_naiss, date_ajout;
	private Groupe groupe;
	private Utilisateur utilisateur;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact")
	public long getId_contact() {
		return id_contact;
	}

	public void setId_contact(long id_contact) {
		this.id_contact = id_contact;
	}

	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "num_tel")
	public String getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}

	@Column(name = "adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "profession")
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "date_naissance")
	public Date getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	@Column(name = "date_ajout")
	public Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	@ManyToOne
	@JoinColumn(name = "id_groupe")
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
