package com.ecolepratique.rapport.service;

import java.util.List;
import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;

/**
 * 
 * @author Utilisateur
 *
 */
public interface VisiteurServiceItf {
	
	/**
	 * 
	 * @param visiteur Visiteur que l'on souhaite créer
	 * @param password Mot de passe du visiteur
	 * @return Visiteur créé
	 */
	Visiteur createVisiteur(Visiteur visiteur, String password);
	
	/**
	 * 
	 * @param id Id du visiteur recherché
	 * @return Visiteur contenant l'id recherché
	 */
	Visiteur findVisiteurById(String id);
	
	/**
	 * 
	 * @param id Id du visiteur à modifier
	 * @param visiteur Nouveau visiteur
	 * @return Visiteur modifié
	 */
	Visiteur updateVisiteurByid(String id, Visiteur visiteur);
	
	/**
	 * 
	 * @param id Id du visiteur à supprimer
	 * @return Visiteur supprimé
	 */
	Visiteur deleteVisiteurById(String id);
	
	/**
	 * 
	 * @return Liste de tous les visiteurs
	 */
	Stream<Utilisateur> listVisiteur();
	
	/**
	 * 
	 * @param date Date d'embauche saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste de tous les visiteurs embauchés avant ou après la date saisie
	 */
	Stream<Utilisateur> listVisiteurByDateEmbauche(String date, String type);
	
	/**
	 * 
	 * @param idVisiteur Id du visiteur dont on cherche les rapports
	 * @return Liste des rapports du visiteur
	 */
	List<Rapport> listRapportByIdVisiteur(String idVisiteur);
	
	/**
	 * 
	 * @param idVisiteur Id du visiteur pour lequel on souhaite créer un rapport
	 * @param rapport Rapport que l'on souhaite créer
	 * @return Rapport créé
	 */
	Rapport createRapport(String idVisiteur, Rapport rapport);

}
