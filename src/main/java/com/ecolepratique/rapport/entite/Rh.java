package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
@DiscriminatorValue("RH")
public class Rh extends Utilisateur{
	
	public Rh() {
		super();
	}

	/**
	 * 
	 * @param login Identifiant du RH
	 * @param nom Nom du RH
	 * @param prenom Prénom du RH
	 * @param adresse Adresse du RH
	 * @param codePostal Code postal du RH
	 * @param ville Ville du RH
	 * @param dateEmbauche Date d'embauche du RH
	 * @param dateNaissance Date de naissance du RH
	 */
	public Rh(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateEmbauche, LocalDate dateNaissance) {
		super(login, nom, prenom, adresse, codePostal, ville, dateEmbauche, dateNaissance);
	}
	
	/**
	 * 
	 * @param login Identifiant du RH
	 * @param nom Nom du RH
	 * @param prenom Prénom du RH
	 * @param adresse Adresse du RH
	 * @param codePostal Code postal du RH
	 * @param ville Ville du RH
	 * @param dateNaissance Date de naissance du RH
	 */
	public Rh(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateNaissance) {
		super(login, nom, prenom, adresse, codePostal, ville, dateNaissance);
	}

	@Override
	public String toString() {
		return "Rh []";
	}
}

