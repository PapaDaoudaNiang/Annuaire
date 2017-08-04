package com.daveNiang.annuaire.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

@ManagedBean(name = "loginController")
@ViewScoped
public class LoginController {

	@ManagedProperty("#{service}")
	private AnnuaireService service;
	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;
	private String username;
	private String password;
	private boolean isOk;
	private Utilisateur utilisateur;
	private Compte compte;

	@PostConstruct
	public void init() {
		compte = new Compte();
		setUtilisateur(new Utilisateur());
		isOk = false;
	}

	public void login() throws IOException {
		isOk = service.Authenticated(username, password);
		if (isOk == true) {

			compte = service.leCompte(username);
			utilisateur = compte.getUtilisateur();

			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("UTILISATEUR", utilisateur);

			Faces.getExternalContext().getFlash().setKeepMessages(true);
			Messages.create("SUCCES").detail("Connexion réussie.").add();
			username = "";
			password = "";
			navigationController.toHomePage();

		} else {
			Messages.create("Error!").error().detail("Login ou Mot de passe incorrect.").add();
			navigationController.toLoginPage();
		}
	}

	public void logout() throws IOException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		navigationController.toLoginPage();
		// navigationController.toLoginPage();
	}

	public AnnuaireService getService() {
		return service;
	}

	public void setService(AnnuaireService service) {
		this.service = service;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
