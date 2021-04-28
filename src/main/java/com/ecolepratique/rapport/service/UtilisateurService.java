package com.ecolepratique.rapport.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.RedacteurChercheurDaoItf;
import com.ecolepratique.rapport.dao.RhDaoItf;
import com.ecolepratique.rapport.dao.UtilisateurDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class UtilisateurService  implements UtilisateurServiceItf{
	
	@Autowired
	private UtilisateurDaoItf utilisateurDao;
	
	@Autowired
	private VisiteurDaoItf visiteurDao;
	
	@Autowired
	private RedacteurChercheurDaoItf redacteurChercheurDao;
	
	@Autowired
	private RhDaoItf rhDao;

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RH")
	@Override
	public List<Double> pourcentageTypesUtilisateurs() {
		
		List<Double>listePourcentages = new ArrayList();	
		double nombreUtilisateurs = utilisateurDao.findAll().stream().count();
		double nombreVisiteurs = visiteurDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Visiteur").count();
		double nombreRedacteursChercheurs = redacteurChercheurDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.RedacteurChercheur").count();
		double nombreRh = rhDao.findAll().stream().filter((user) -> user.getClass().getName() == "com.ecolepratique.rapport.entite.Rh").count();
		
		double pourcentageVisiteurs = nombreVisiteurs * 100 / nombreUtilisateurs;
		double pourcentageRedacteursChercheurs = nombreRedacteursChercheurs * 100 / nombreUtilisateurs;
		double pourcentageRh = nombreRh * 100 / nombreUtilisateurs;
		
		listePourcentages.add(pourcentageVisiteurs);
		listePourcentages.add(pourcentageRedacteursChercheurs);
		listePourcentages.add(pourcentageRh);
		
		return listePourcentages;
	}

}
