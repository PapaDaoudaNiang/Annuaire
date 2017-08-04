package com.daveNiang.annuaire.controllers;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "navigationController")
public class NavigationController {

	public void toHomePage() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("views/index.xhtml");
	}

	public void toLoginPage() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("login.xhtml");
	}

}
