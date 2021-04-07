package com.ecolepratique.rapport.service;

import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Utilisateur
 *
 */
public interface RedacteurChercheurServiceItf {
	
	/**
	 * 
	 * @param redacteurChercheur Rédacteur/Chercheur que l'on souhaite créer
	 * @param password Mot de passe du rédacteur/chercheur
	 * @return Rédacteur/Chercheur créé
	 */
	RedacteurChercheur createRedacteurChercheur(RedacteurChercheur redacteurChercheur, String password);
	
	/**
	 * 
	 * @param id Id du rédacteur/chercheur recherché
	 * @return Rédacteur/Chercheur contenant l'id recherché
	 */
	RedacteurChercheur findRedacteurChercheurById(String id);
	
	/**
	 * 
	 * @param id Id du rédacteur/chercheur à modifier
	 * @param redacteurChercheur Nouveau rédacteur/chercheur
	 * @return Rédacteur/Chercheur modifié
	 */
	RedacteurChercheur updateRedacteurChercheurByid(String id, RedacteurChercheur redacteurChercheur);
	
	/**
	 * 
	 * @param id Id du rédacteur/chercheur à supprimer
	 * @return Rédacteur/Chercheur supprimé
	 */
	RedacteurChercheur deleteRedacteurChercheurById(String id);
	
	/**
	 * 
	 * @return Liste des rédacteurs/chercheurs
	 */
	Stream<Utilisateur> listRedacteurChercheur();
	
	/**
	 * 
	 * @param date Date d'embauche saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste de tous les rédacteurs/chercheurs embauchés avant ou après la date recherchée
	 */
	Stream<Utilisateur> listRedacteurChercheurByDateEmbauche(String date, String type);
}
