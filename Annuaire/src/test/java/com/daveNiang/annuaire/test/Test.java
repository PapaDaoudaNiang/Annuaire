package com.daveNiang.annuaire.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Profil;
import com.daveNiang.annuaire.entities.Utilisateur;
import com.daveNiang.annuaire.service.AnnuaireService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		AnnuaireService service = (AnnuaireService) context.getBean("service");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("niang");
		utilisateur.setPrenom("dave");
		utilisateur = service.creerUtilisateur(utilisateur);
		Compte compte = new Compte();
		compte.setLogin("admin");
		compte.setMotDePasse("admin");
		compte.setUtilisateur(utilisateur);
		service.creerCompte(compte);
		utilisateur.setCompte(compte);
		Profil profil = new Profil();
		profil.setNom("ADMINISTRATEUR");
		profil.setDescription("P Admin");
		service.creerProfil(profil);
		utilisateur.setProfil(profil);
		service.modifierUtilisateur(utilisateur);
//		Groupe groupe = new Groupe();
//		groupe.setNom("amis");
//		groupe.setDescription("les amis");
//		groupe.setUtilisateur(service.TheUSer(1));
//		service.creerGroupe(groupe);

	}

}
