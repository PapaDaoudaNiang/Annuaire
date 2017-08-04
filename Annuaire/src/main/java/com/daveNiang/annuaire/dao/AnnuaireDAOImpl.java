package com.daveNiang.annuaire.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.daveNiang.annuaire.entities.Compte;
import com.daveNiang.annuaire.entities.Contact;
import com.daveNiang.annuaire.entities.Groupe;
import com.daveNiang.annuaire.entities.Utilisateur;

public class AnnuaireDAOImpl implements AnnuaireDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		em.persist(utilisateur);
		return utilisateur;
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		em.merge(utilisateur);
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		String sql = "from Utilisateur";
		TypedQuery<Utilisateur> query = em.createQuery(sql, Utilisateur.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		em.find(Utilisateur.class, utilisateur.getId_utilisateur());
		em.remove(em.merge(utilisateur));
	}

	@Override
	public Utilisateur TheUSer(long id) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur;
		utilisateur = em.find(Utilisateur.class, id);
		return utilisateur;
	}

	@Override
	public Compte creerCompte(Compte compte) {
		// TODO Auto-generated method stub
		em.persist(compte);
		return compte;
	}

	@Override
	public void modifierCompte(Compte compte) {
		// TODO Auto-generated method stub
		em.merge(compte);
	}

	@Override
	public List<Compte> getAllComptes() {
		// TODO Auto-generated method stub
		String sql = "from Compte";
		TypedQuery<Compte> query = em.createQuery(sql, Compte.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void supprimerCompte(Compte compte) {
		// TODO Auto-generated method stub
		em.find(Compte.class, compte.getId_compte());
		em.remove(em.merge(compte));
	}

	@Override
	public Compte leCompte(String login) {
		// TODO Auto-generated method stub
		Compte compte = new Compte();
		String sql = "from Compte where login = :log";
		Query query = em.createQuery(sql);
		query.setParameter("log", login);
		if (!query.getResultList().isEmpty()) {
			compte = (Compte) query.getSingleResult();
			return compte;
		} else {
			return null;
		}
	}

	@Override
	public boolean Authenticated(String login, String mdp) {
		// TODO Auto-generated method stub
		Compte compte = new Compte();
		boolean isOk = false;
		String sql = "select cp from Compte cp where cp.login = :log";
		Query query = em.createQuery(sql);
		query.setParameter("log", login);
		compte = (Compte) query.getSingleResult();

		if (compte.getMotDePasse().equals(mdp)) {
			isOk = true;
			return isOk;
		} else {
			return isOk;
		}
	}

	@Override
	public Contact creerContact(Contact contact) {
		// TODO Auto-generated method stub
		em.persist(contact);
		return contact;
	}

	@Override
	public void modifierContact(Contact contact) {
		// TODO Auto-generated method stub
		em.merge(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		String sql = "from Contact";
		TypedQuery<Contact> query = em.createQuery(sql, Contact.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void supprimerContact(Contact contact) {
		// TODO Auto-generated method stub
		em.find(Contact.class, contact.getId_contact());
		em.remove(em.merge(contact));
	}

	@Override
	public Contact leContact(long idContact) {
		// TODO Auto-generated method stub
		Contact contact = em.find(Contact.class, idContact);
		return contact;
	}

	@Override
	public List<Contact> getContactByUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String sql = "select c from Contact c where c.utilisateur = :userID";
		TypedQuery<Contact> query = em.createQuery(sql, Contact.class);
		query.setParameter("userID", utilisateur);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Groupe creerGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		em.persist(groupe);
		return groupe;
	}

	@Override
	public void modifierGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		em.merge(groupe);
	}

	@Override
	public List<Groupe> getAllGroupes() {
		// TODO Auto-generated method stub
		String sql = "from Groupe";
		TypedQuery<Groupe> query = em.createQuery(sql, Groupe.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void supprimerGroupe(Groupe groupe) {
		// TODO Auto-generated method stub
		em.find(Groupe.class, groupe.getId_groupe());
		em.remove(em.merge(groupe));
	}

	@Override
	public Groupe leGroupe(long idGroupe) {
		// TODO Auto-generated method stub
		Groupe groupe = em.find(Groupe.class, idGroupe);
		return groupe;
	}

	@Override
	public List<Groupe> getGroupeByUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String sql = "select g from Groupe g where g.utilisateur = :userID";
		TypedQuery<Groupe> query = em.createQuery(sql, Groupe.class);
		query.setParameter("userID", utilisateur);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

}
