package com.daveNiang.annuaire.service;

import java.util.List;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Contact;
import com.daveNiang.annuaire.entities.Groupe;
import com.daveNiang.annuaire.entities.Utilisateur;

public interface AnnuaireService {

	// --------------------------------------------------------------
	// UTILISATEUR

	public Utilisateur creerUtilisateur(Utilisateur utilisateur);

	public void modifierUtilisateur(Utilisateur utilisateur);

	public List<Utilisateur> getAllUtilisateurs();

	public void supprimerUtilisateur(Utilisateur utilisateur);

	public Utilisateur TheUSer(long id);

	// ----------------------------------------------------------------
	// COMPTE

	public Compte creerCompte(Compte compte);

	public void modifierCompte(Compte compte);

	public List<Compte> getAllComptes();

	public void supprimerCompte(Compte compte);

	public Compte leCompte(String login);

	public boolean Authenticated(String login, String mdp);

	// ----------------------------------------------------------------
	// CONTACT

	public Contact creerContact(Contact contact);

	public void modifierContact(Contact contact);

	public List<Contact> getAllContacts();

	public void supprimerContact(Contact contact);

	public Contact leContact(long idContact);

	public List<Contact> getContactByUser(Utilisateur utilisateur);

	// ----------------------------------------------------------------
	// GROUPE
	public Groupe creerGroupe(Groupe groupe);

	public void modifierGroupe(Groupe groupe);

	public List<Groupe> getAllGroupes();

	public void supprimerGroupe(Groupe groupe);

	public Groupe leGroupe(long idGroupe);

	public List<Groupe> getGroupeByUser(Utilisateur utilisateur);

}
