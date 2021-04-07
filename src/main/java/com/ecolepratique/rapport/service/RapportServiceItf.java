package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.entite.Rapport;

/**
 * 
 * @author Utilisateur
 *
 */
public interface RapportServiceItf {
	
	/**
	 * 
	 * @return Liste de tous les rapports
	 */
	List<Rapport> listRapport();
	
	/**
	 * 
	 * @param id Id du rapport recherché
	 * @return Rapport contenant l'id recherché
	 */
	Rapport findRapportById(Long id);
	
	/**
	 * 
	 * @param id Id du rapport à modifier
	 * @param rapport Nouveau rapport
	 * @return Rapport modifié
	 */
	Rapport updateRapport(Long id, Rapport rapport);
	
	/**
	 * 
	 * @param id Id du rapport à supprimer
	 * @return Rapport supprimé
	 */
	Rapport deleteById(Long id);
	
	/**
	 * 
	 * @param champ Champ contenant le mot clé recherché
	 * @param motCle Mot clé contenu dans le champ recherché
	 * @return Liste des médicaments contenant le mot clé dans le champ précisé
	 */
	List<Rapport> listRapportByChampEtMotCle(String champ, String motCle);
	
	/**
	 * 
	 * @param date Date saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste de tous les rapports rédigés avant ou après la date saisie
	 */
	List<Rapport> listRapportByDate(String date, String type);
	
	/**
	 * 
	 * @param idRapport Id du rapport pour lequel on souhaite créer une offre
	 * @param offre Offre que l'on souhaite créer
	 * @return Offre créée
	 */
	OffreEchantillon createOffreEchantillon(Long idRapport, OffreEchantillon offre);
}
