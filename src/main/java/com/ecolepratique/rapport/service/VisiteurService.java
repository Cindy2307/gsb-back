package com.ecolepratique.rapport.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.RapportDaoItf;
import com.ecolepratique.rapport.dao.UserDaoItf;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class VisiteurService implements VisiteurServiceItf {
	
	@Autowired
	private VisiteurDaoItf visiteurDao;
	
	@Autowired
	private RapportDaoItf rapportDao;
	
	@Autowired
	private UserRoleDaoItf utilisateurRoleDao;
	
	@Autowired
	private UserDaoItf userDao;

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Visiteur createVisiteur(Visiteur visiteur, String password) {
		System.out.println("hello" + visiteur);
		visiteur.setDateEmbauche(LocalDate.now());
		utilisateurRoleDao.save(new UserRole(visiteur.getLogin(), "VIS"));
		userDao.save(new User(visiteur.getLogin(), password));
		return visiteurDao.save(visiteur);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listVisiteur() {
		return visiteurDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Visiteur");
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Visiteur findVisiteurById(String id) {
		return (Visiteur) visiteurDao.findById(id).get();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Visiteur updateVisiteurByid(String id, Visiteur visiteur) {
		Visiteur ancienVisiteur = findVisiteurById(id);
		visiteur.setLogin(id);
		visiteur.setDateEmbauche(ancienVisiteur.getDateEmbauche());
		visiteur.setRapports(ancienVisiteur.getRapports());
		return visiteurDao.save(visiteur);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Visiteur deleteVisiteurById(String id) {
		Visiteur visiteur = findVisiteurById(id);
		visiteurDao.deleteById(id);
		return visiteur;
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_VIS")
	@Override
	public Rapport createRapport(String idVisiteur, Rapport rapport) {
		rapport.setDate(LocalDate.now());
		rapport = rapportDao.save(rapport);
		Visiteur visiteur = findVisiteurById(idVisiteur);
		visiteur.addRapport(rapport);
		visiteurDao.save(visiteur);
		return rapport;
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_RC", "ROLE_VIS"})
	@Override
	public List<Rapport> listRapportByIdVisiteur(String idVisiteur) {
		return findVisiteurById(idVisiteur).getRapports();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listVisiteurByDateEmbauche(String date, String type) {
		String[] tab = date.split("-");
		Stream<Utilisateur> visiteurs = null;
		if (type.equals("after"))
			visiteurs = visiteurDao.findByDateEmbaucheAfter(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Visiteur");
		else if (type.equals("before"))
			visiteurs = visiteurDao.findByDateEmbaucheBefore(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Visiteur");
		return visiteurs;
	}

}
