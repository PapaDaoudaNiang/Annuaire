package com.daveNiang.annuaire.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.daveNiang.annuaire.dao.AnnuaireDAO;
import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Contact;
import com.daveNiang.annuaire.entities.Groupe;
import com.daveNiang.annuaire.entities.Profil;
import com.daveNiang.annuaire.entities.Utilisateur;

@Transactional
public class AnnuaireServiceImpl implements AnnuaireService {

	private AnnuaireDAO dao;

	public void setDao(AnnuaireDAO dao) {
		this.dao = dao;
	}

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return dao.creerUtilisateur(utilisateur);
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		dao.modifierUtilisateur(utilisateur);
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return dao.getAllUtilisateurs();
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		dao.supprimerUtilisateur(utilisateur);
	}

	@Override
	public Utilisateur TheUSer(long id) {
		// TODO Auto-generated method stub
		return dao.TheUSer(id);
	}

	@Override
	public Compte creerCompte(Compte compte) {
		// TODO Auto-generated method stub
		return dao.creerCompte(compte);
	}

	@Override
	public void modifierCompte(Compte compte) {
		// TODO Auto-generated method stub
		dao.modifierCompte(compte);
	}

	@Override
	public List<Compte> getAllComptes() {
		// TODO Auto-generated method stub
		return dao.getAllComptes();
	}

	@Override
	public void supprimerCompte(Compte compte) {
		// TODO Auto-generated method stub
		dao.supprimerCompte(compte);
	}

	@Override
	public Compte leCompte(String login) {
		// TODO Auto-generated method stub
		return dao.leCompte(login);
	}

	@Override
	public boolean Authenticated(String login, String mdp) {
		// TODO Auto-generated method stub
		return dao.Authenticated(login, mdp);
	}

	@Override
	public Contact creerContact(Contact contact) {
		// TODO Auto-generated method stub
		return dao.creerContact(contact);
	}

	@Override
	public void modifierContact(Contact contact) {
		// TODO Auto-generated method stub
		dao.modifierContact(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return dao.getAllContacts();
	}

	@Override
	public void supprimerContact(Contact contact) {
		// TODO Auto-generated method stub
		dao.supprimerContact(contact);
	}

	@Override
	public Contact leContact(long idContact) {
		// TODO Auto-generated method stub
		return dao.leContact(idContact);
	}

	@Override
	public List<Contact> getContactByUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return dao.getContactByUser(utilisateur);
	}

	@Override
	public Groupe creerGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		return dao.creerGroupe(groupe);
	}

	@Override
	public void modifierGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		dao.modifierGroupe(groupe);
	}

	@Override
	public List<Groupe> getAllGroupes() {
		// TODO Auto-generated method stub
		return dao.getAllGroupes();
	}

	@Override
	public void supprimerGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		dao.supprimerGroupe(groupe);
	}

	@Override
	public Groupe leGroupe(long idGroupe) {
		// TODO Auto-generated method stub
		return dao.leGroupe(idGroupe);
	}

	@Override
	public List<Groupe> getGroupeByUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return dao.getGroupeByUser(utilisateur);
	}
	
	@Override
	public Profil creerProfil(Profil profil) {
		// TODO Auto-generated method stub
		return dao.creerProfil(profil);
	}

	@Override
	public void modifierProfil(Profil profil) {
		// TODO Auto-generated method stub
		dao.modifierProfil(profil);
	}

	@Override
	public List<Profil> getAllProfils() {
		// TODO Auto-generated method stub
		return dao.getAllProfils();
	}

	@Override
	public void supprimerProfil(Profil profil) {
		// TODO Auto-generated method stub
		dao.supprimerProfil(profil);
	}
	
	@Override
	public Profil leProfil(String nom) {
		// TODO Auto-generated method stub
		return dao.leProfil(nom);
	}

}
