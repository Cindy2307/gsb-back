package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.OffreEchantillon;

/**
 * 
 * @author Utilisateur
 *
 */
public interface OffreEchantillonServiceItf {
	
	/**
	 * 
	 * @param id Id de l'offre recherchée
	 * @return Offre contenant l'id recherché
	 */
	OffreEchantillon findOffreEchantillonById(Long id);

	/**
	 * 
	 * @param id Id de l'offre à modifier
	 * @param offre Nouvelle offre
	 * @return Offre modifiée
	 */
	OffreEchantillon updateOffreEchantillonByid(Long id, OffreEchantillon offre);
	
	/**
	 * 
	 * @param id Id de l'offre à supprimer
	 * @return Offre supprimée
	 */
	OffreEchantillon deleteOffreEchantillon(Long id);
	
	/**
	 * 
	 * @return Liste des offres d'échantillons
	 */
	List<OffreEchantillon> listOffreEchantillon();
}
