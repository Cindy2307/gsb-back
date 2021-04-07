package com.ecolepratique.rapport.service;

import java.time.LocalDate;
import java.util.stream.Stream;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.RedacteurChercheurDaoItf;
import com.ecolepratique.rapport.dao.UserDaoItf;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class RedacteurChercheurService implements RedacteurChercheurServiceItf {
	
	@Autowired
	private RedacteurChercheurDaoItf redacteurChercheurDao;
	
	@Autowired
	private UserRoleDaoItf utilisateurRoleDao;
	
	@Autowired
	private UserDaoItf userDao;

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public RedacteurChercheur createRedacteurChercheur(RedacteurChercheur redacteurChercheur, String password) {
		System.out.println("hello" + redacteurChercheur);
		redacteurChercheur.setDateEmbauche(LocalDate.now());
		utilisateurRoleDao.save(new UserRole(redacteurChercheur.getLogin(), "RC"));
		userDao.save(new User(redacteurChercheur.getLogin(), password));
		return redacteurChercheurDao.save(redacteurChercheur);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listRedacteurChercheur() {
		return redacteurChercheurDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.RedacteurChercheur");
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public RedacteurChercheur findRedacteurChercheurById(String id) {
		return (RedacteurChercheur) redacteurChercheurDao.findById(id).get();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public RedacteurChercheur updateRedacteurChercheurByid(String id, RedacteurChercheur redacteurChercheur) {
		RedacteurChercheur ancienRedacteurChercheur = findRedacteurChercheurById(id);
		redacteurChercheur.setLogin(id);
		redacteurChercheur.setDateEmbauche(ancienRedacteurChercheur.getDateEmbauche());
		return redacteurChercheurDao.save(redacteurChercheur);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public RedacteurChercheur deleteRedacteurChercheurById(String id) {
		RedacteurChercheur redacteurChercheur = findRedacteurChercheurById(id);
		redacteurChercheurDao.deleteById(id);
		return redacteurChercheur;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listRedacteurChercheurByDateEmbauche(String date, String type) {
		String[] tab = date.split("-");
		Stream<Utilisateur> rcs = null;
		if (type.equals("after"))
			rcs = redacteurChercheurDao.findByDateEmbaucheAfter(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.RedacteurChercheur");
		else if (type.equals("before"))
			rcs = redacteurChercheurDao.findByDateEmbaucheBefore(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.RedacteurChercheur");
		return rcs;
	}

}
