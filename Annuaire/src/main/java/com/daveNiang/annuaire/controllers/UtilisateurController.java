package com.daveNiang.annuaire.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

@ViewScoped
@ManagedBean(name = "utilisateurController")
public class UtilisateurController {

	@ManagedProperty("#{service}")
	private AnnuaireService service;
	@ManagedProperty("#{templateController}")
	private TemplateController templateController;
	private Utilisateur utilisateur;
	private Utilisateur selectedUtilsateur;
	private List<Utilisateur> utilisateurs;

	@PostConstruct
	public void init() {
		utilisateur = templateController.getUtilisateur();
		utilisateur = new Utilisateur();
		utilisateurs = service.getAllUtilisateurs();
	}

	public void saveUser() {
		utilisateur = service.creerUtilisateur(utilisateur);
		Compte compte = new Compte();
		compte.setLogin(utilisateur.getNom());
		compte.setMotDePasse(utilisateur.getNom());
		compte.setUtilisateur(utilisateur);
		service.creerCompte(compte);
		utilisateur.setCompte(compte);
		service.modifierUtilisateur(utilisateur);
		utilisateur = new Utilisateur();
		compte = new Compte();
		Messages.create("SUCCES").detail("Utilisateur créé avec succés.").add();
	}

	public void updateUser() {
		service.modifierUtilisateur(selectedUtilsateur);
		selectedUtilsateur = new Utilisateur();
		templateController.loadUserListPage();
		Messages.create("SUCCES").detail("Utilisateur modifié avec succés.").add();
	}

	public void deleteUser() {
		service.supprimerUtilisateur(selectedUtilsateur);
		selectedUtilsateur = new Utilisateur();
		templateController.loadAddUserPage();
		Messages.create("SUCCES").detail("Utilisateur modifié avec succés.").add();
	}

	public AnnuaireService getService() {
		return service;
	}

	public void setService(AnnuaireService service) {
		this.service = service;
	}

	public TemplateController getTemplateController() {
		return templateController;
	}

	public void setTemplateController(TemplateController templateController) {
		this.templateController = templateController;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getSelectedUtilsateur() {
		return selectedUtilsateur;
	}

	public void setSelectedUtilsateur(Utilisateur selectedUtilsateur) {
		this.selectedUtilsateur = selectedUtilsateur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
