package com.ecolepratique.rapport.service;

import java.time.LocalDate;
import java.util.stream.Stream;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.RhDaoItf;
import com.ecolepratique.rapport.dao.UserDaoItf;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class RhService implements RhServiceItf {
	
	@Autowired
	private RhDaoItf rhDao;
	
	@Autowired
	private UserRoleDaoItf utilisateurRoleDao;
	
	@Autowired
	private UserDaoItf userDao;

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Rh createRh(Rh rh, String password) {
		System.out.println("hello" + rh);
		rh.setDateEmbauche(LocalDate.now());
		utilisateurRoleDao.save(new UserRole(rh.getLogin(),"RH"));
		userDao.save(new User(rh.getLogin(), password));
		return rhDao.save(rh);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listRh() {
		return rhDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Rh");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Rh findRhById(String id) {
		return (Rh) rhDao.findById(id).get();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Rh updateRhByid(String id, Rh rh) {
		Rh ancienVisiteur = findRhById(id);
		rh.setLogin(id);
		rh.setDateEmbauche(ancienVisiteur.getDateEmbauche());
		return rhDao.save(rh);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Rh deleteRhById(String id) {
		Rh rh = findRhById(id);
		rhDao.deleteById(id);
		return rh;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public Stream<Utilisateur> listRhByDateEmbauche(String date, String type) {
		String[] tab = date.split("-");
		Stream<Utilisateur> rhs = null;
		if (type.equals("after"))
			rhs = rhDao.findByDateEmbaucheAfter(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Rh");
		else if (type.equals("before"))
			rhs = rhDao.findByDateEmbaucheBefore(
					LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]))).stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Rh");
		return rhs;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long numberOfRh() {
		return listRh().count();
	}
	
	
}
