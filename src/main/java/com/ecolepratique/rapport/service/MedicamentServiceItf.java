package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.Medicament;

/**
 * 
 * @author Utilisateur
 *
 */
public interface MedicamentServiceItf {
	/**
	 * 
	 * @param medicament Médicament à créer
	 * @return Médicament créé
	 */
	Medicament create(Medicament medicament);
	
	/**
	 * 
	 * @return Liste de tous les médicaments
	 */
	List<Medicament> list();
	
	/**
	 * 
	 * @param numDepotLegal Numéro de dépot légal du médicament recherché
	 * @return Médicament contenant le numéro de dépot légal
	 */
	Medicament getByNumDepotLegal(Long numDepotLegal);
	
	/**
	 * 
	 * @param numDepotLegal Numéro de dépot légal du médicament à supprimer
	 * @return Médicament supprimé
	 */
	Medicament deleteByNumDepotLegal(Long numDepotLegal);
	
	/**
	 * 
	 * @param numDepotLegal Numéro de dépot légal du médicament à modifier
	 * @param medicament Nouveau médicament
	 * @return Médicament modifié
	 */
	Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament);
	
	/**
	 * 
	 * @param numPage Numéro de page recherché
	 * @param taille Nombre de médicament contenus dans une page
	 * @return Liste des médicament contenus dans la page recherchée
	 */
	List<Medicament> listByPage(int numPage, int taille);
	
	/**
	 * 
	 * @param nomCommercial Nom commercial du médicament recherché
	 * @return Médicament contenant le nom commercial recherché
	 */
	Medicament getByNomCommercial(String nomCommercial);
	
	/**
	 * 
	 * @param mc Mot clé recherché dans le nom commercial d'un médicament
	 * @return Médicament dont le nom commercial contient le mot clé
	 */
	List<Medicament> getByNomCommercialLike(String mc);
	
	/**
	 * 
	 * @return Liste de tous les médicaments triés par nom commercial dans l'ordre alphabétique
	 */
	List<Medicament> listOrderByNomCommercial();
	
	/**
	 * 
	 * @param mc Mot clé contenu dans le nom commercial du médicament recherché
	 * @return Liste des médicaments portant un nom commercial contenant ce mot clé
	 */
	List<Medicament> getByNomCommercialLikeOrder(String mc);
}
