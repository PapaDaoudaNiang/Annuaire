package com.daveNiang.annuaire.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import com.daveNiang.annuaire.entities.Groupe;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

@ViewScoped
@ManagedBean(name = "groupeController")
public class GroupeController {

	@ManagedProperty("#{service}")
	private AnnuaireService service;
	@ManagedProperty("#{templateController}")
	private TemplateController templateController;
	private Utilisateur utilisateur;
	private List<Groupe> groupes = new ArrayList<Groupe>();
	private Groupe groupe = new Groupe();
	private Groupe selectedGroupe = new Groupe();
	private Groupe todelete = new Groupe();

	@PostConstruct
	public void init() {
		utilisateur = templateController.getUtilisateur();
		groupe = new Groupe();
		groupes = service.getGroupeByUser(utilisateur);
	}

	public void saveGroup() {
		groupe.setUtilisateur(utilisateur);
		service.creerGroupe(groupe);
		groupe = new Groupe();
		templateController.loadGroupPage();
		// addMessage("System Succes", "Groupe créé avec succés.");
		Messages.create("SUCCES").detail("Groupe créé avec succés.").add();
	}

	public void updateGroup() {
		service.modifierGroupe(selectedGroupe);
		selectedGroupe = new Groupe();
		templateController.loadGroupPage();
		Messages.create("SUCCES").detail("Groupe modifié avec succés.").add();
	}

	public void deleteGroup() {
		// Groupe groupe = service.leGroupe(idG);
		// service.supprimerGroupe(todelete);
		service.creerGroupe(todelete);
		todelete = new Groupe();
		selectedGroupe = new Groupe();
		templateController.loadGroupPage();
		Messages.create("SUCCES").detail("Groupe supprimé avec succés.").add();
	}

	public void setGroupTodelete() {
		todelete = selectedGroupe;
		deleteGroup();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Groupe getSelectedGroupe() {
		return selectedGroupe;
	}

	public void setSelectedGroupe(Groupe selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}

	public Groupe getTodelete() {
		return todelete;
	}

	public void setTodelete(Groupe todelete) {
		this.todelete = todelete;
	}

}
