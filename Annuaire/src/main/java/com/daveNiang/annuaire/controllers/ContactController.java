package com.daveNiang.annuaire.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.daveNiang.annuaire.entities.Contact;
import com.daveNiang.annuaire.entities.Groupe;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

@ViewScoped
@ManagedBean(name = "contactController")
public class ContactController {

	@ManagedProperty("#{service}")
	private AnnuaireService service;
	@ManagedProperty("#{templateController}")
	private TemplateController templateController;
	private Utilisateur utilisateur;
	private Contact contact;
	private Contact selectedContact;
	private List<Contact> contacts = new ArrayList<Contact>();
	private List<Groupe> groupes = new ArrayList<Groupe>();
	private String selectedGroupe;
	private List<String> groupeLabels = new ArrayList<String>();
	private Map<String, Groupe> LabelsGroupesMap = new HashMap<String, Groupe>();
	private List<Contact> filteredContacts;

	@PostConstruct
	public void init() {
		utilisateur = templateController.getUtilisateur();
		contact = new Contact();
		// if(!utilisateur.getContacts().isEmpty())
		contacts = service.getContactByUser(utilisateur);
		// if(!utilisateur.getGroupes().isEmpty())
		groupes = service.getGroupeByUser(utilisateur);
		for (Groupe groupe : groupes) {
			groupeLabels.add(groupe.getNom());
			LabelsGroupesMap.put(groupe.getNom(), groupe);
		}
	}

	public void saveContact() {
		contact.setUtilisateur(utilisateur);
		contact.setDate_ajout(new Date());
		contact.setGroupe(LabelsGroupesMap.get(selectedGroupe));
		service.creerContact(contact);
		contact = new Contact();
		selectedGroupe = null;
		Messages.create("SUCCES").detail("Contact créé avec succés.").add();
	}

	public void updateContact() {
		service.modifierContact(selectedContact);
		selectedContact = new Contact();
		templateController.loadContactListPage();
		Messages.create("SUCCES").detail("Contact modifié avec succés.").add();
	}

	public void deleteContact() {
		// Groupe groupe = service.leGroupe(idG);
		// service.supprimerGroupe(todelete);
		// service.creerGroupe(todelete);
		// todelete = new Groupe();
		// selectedGroupe = new Groupe();
		// templateController.loadGroupPage();
		// Messages.create("SUCCES").detail("Groupe supprimé avec
		// succés.").add();
	}

	public AnnuaireService getService() {
		return service;
	}

	public void setService(AnnuaireService service) {
		this.service = service;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public String getSelectedGroupe() {
		return selectedGroupe;
	}

	public void setSelectedGroupe(String selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}

	public Map<String, Groupe> getLabelsGroupesMap() {
		return LabelsGroupesMap;
	}

	public void setLabelsGroupesMap(Map<String, Groupe> labelsGroupesMap) {
		LabelsGroupesMap = labelsGroupesMap;
	}

	public List<String> getGroupeLabels() {
		return groupeLabels;
	}

	public void setGroupeLabels(List<String> groupeLabels) {
		this.groupeLabels = groupeLabels;
	}

	public TemplateController getTemplateController() {
		return templateController;
	}

	public void setTemplateController(TemplateController templateController) {
		this.templateController = templateController;
	}

	public Contact getSelectedContact() {
		return selectedContact;
	}

	public void setSelectedContact(Contact selectedContact) {
		this.selectedContact = selectedContact;
	}

	public List<Contact> getFilteredContacts() {
		return filteredContacts;
	}

	public void setFilteredContacts(List<Contact> filteredContacts) {
		this.filteredContacts = filteredContacts;
	}

}
