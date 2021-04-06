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
public interface RedacteurChercheurDaoItf  extends JpaRepository<Utilisateur, String>{
	/**
	 * 
	 * @param date Date de l'embauche
	 * @return Liste d'utilisateurs embauchés après la date indiquée
	 */
	List<Utilisateur> findByDateEmbaucheAfter(LocalDate date);
	
	/**
	 * 
	 * @param date Date de l'embauche
	 * @return Liste d'utilisateurs embauchés avant la date indiquée
	 */
	List<Utilisateur> findByDateEmbaucheBefore(LocalDate date);
}
