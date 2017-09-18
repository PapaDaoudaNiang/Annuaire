package com.daveNiang.annuaire.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Ajax;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

@ManagedBean(name = "templateController")
@ViewScoped
public class TemplateController {
	@ManagedProperty("#{service}")
	private AnnuaireService service;

	private String page;
	private Utilisateur utilisateur;
	private String oldPassword = "";
	private String newPassword = "";
	private String confirmNewPassword = "";
	private String AdminVisibility;

	@PostConstruct
	public void init() {
		this.page = "/views/home.xhtml";

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

		utilisateur = (Utilisateur) session.getAttribute("UTILISATEUR");

		if (utilisateur.getProfil().getNom().equals("ADMINISTRATEUR")) {
			AdminVisibility = "";
		} else {
			AdminVisibility = "none";
		}

	}

	public String getAdminVisibility() {
		return AdminVisibility;
	}

	public void setAdminVisibility(String adminVisibility) {
		AdminVisibility = adminVisibility;
	}

	public void changePWD() {
		if (utilisateur.getCompte().getMotDePasse().equals(oldPassword)) {
			if (newPassword.equals(confirmNewPassword)) {
				Compte compte = utilisateur.getCompte();
				compte.setMotDePasse(newPassword);
				service.modifierCompte(compte);
				Messages.create("SUCCES     ").detail("Mot de passe modifié avec succés.").add();
				RequestContext requestContext = RequestContext.getCurrentInstance();
				requestContext.execute("PF('changeMDPDialog').hide()");
			} else {
				Messages.create("Error!    ").error()
						.detail("Vérifiez votre saisi !!! Les mots de passe saisi sont différents").add();
			}
		} else {
			Messages.create("Error!    ").error().detail("Le mot de passe saisi est incorrect.").add();

		}
		oldPassword = null;
		newPassword = null;
		confirmNewPassword = null;
	}

	public void reloadPage(String bean) {
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(bean);
	}

	public void loadAddContactPage() {
		this.page = "/views/addContact.xhtml";
		reloadPage("contactController");
		RequestContext.getCurrentInstance().update("dynamicContent");
		// Ajax.update("dynamicContent");
	}

	public void loadContactListPage() {
		this.page = "/views/ContactList.xhtml";
		reloadPage("contactController");
		Ajax.update("dynamicContent");
	}

	public void loadGroupPage() {
		this.page = "/views/Group.xhtml";
		reloadPage("groupeController");
		RequestContext.getCurrentInstance().update("dynamicContent");
		// Ajax.update("dynamicContent");
	}

	public void loadAddUserPage() {
		this.page = "/views/addUser.xhtml";
		reloadPage("utilisateurController");
		Ajax.update("dynamicContent");
	}

	public void loadUserListPage() {
		this.page = "/views/UserList.xhtml";
		reloadPage("utilisateurController");
		Ajax.update("dynamicContent");
	}

	public void loadProfilPage() {
		this.page = "/views/Profil.xhtml";
		reloadPage("profilController");
		Ajax.update("dynamicContent");
	}

	public AnnuaireService getService() {
		return service;
	}

	public void setService(AnnuaireService service) {
		this.service = service;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

}
