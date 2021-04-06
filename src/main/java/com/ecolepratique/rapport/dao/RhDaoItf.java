package com.ecolepratique.rapport.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Christophe
 *
 */
public interface RhDaoItf extends JpaRepository<Utilisateur, String>{
	/**
	 * 
	 * @param date Date d'embauche
	 * @return Liste des utilisateurs embauchés apres la date saisie
	 */
	List<Utilisateur> findByDateEmbaucheAfter(LocalDate date);
	
	/**
	 * 
	 * @param date Date d'embauche
	 * @return Liste des utilisateurs embauchés avant la date saisie
	 */
	List<Utilisateur> findByDateEmbaucheBefore(LocalDate date);
}
