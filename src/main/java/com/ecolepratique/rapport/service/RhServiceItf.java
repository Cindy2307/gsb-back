package com.ecolepratique.rapport.service;

import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Utilisateur
 *
 */
public interface RhServiceItf {
	
	/**
	 * 
	 * @param rh Rh à créer
	 * @param password Mod de passe du RH
	 * @return RH créé
	 */
	Rh createRh(Rh rh, String password);
	
	/**
	 * 
	 * @param id Id du RH recherché
	 * @return RH contenant l'id recherché
	 */
	Rh findRhById(String id);
	
	/**
	 * 
	 * @param id Id du RH à modifier
	 * @param rh Nouveau RH
	 * @return RH modifié
	 */
	Rh updateRhByid(String id, Rh rh);
	
	/**
	 * 
	 * @param id Id du RH à supprimer
	 * @return RH supprimé
	 */
	Rh deleteRhById(String id);
	
	/**
	 * 
	 * @return Liste de tous les RH
	 */
	Stream<Utilisateur> listRh();
	
	/**
	 * 
	 * @param date Date d'embauche saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste des RH embauchés avant ou après la date saisie
	 */
	Stream<Utilisateur> listRhByDateEmbauche(String date, String type);
	
	/**
	 * 
	 * @return Nombre de RH
	 */
	Long numberOfRh();
}
