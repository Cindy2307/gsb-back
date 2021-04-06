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
@DiscriminatorValue("RC")
public class RedacteurChercheur extends Utilisateur{
	
	public RedacteurChercheur() {
		super();
	}

	/**
	 * 
	 * @param login Identifiant du rédacteur/chercheur
	 * @param nom Nom du rédacteur/chercheur
	 * @param prenom Prénom du rédacteur/chercheur
	 * @param adresse Adresse du rédacteur/chercheur
	 * @param codePostal Code postal du rédacteur/chercheur
	 * @param ville Ville du rédacteur/chercheur
	 * @param dateNaissance Date de naissance du rédacteur/chercheur
	 */
	public RedacteurChercheur(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateNaissance) {
		super(login, nom, prenom, adresse, codePostal, ville, dateNaissance);
	}

	@Override
	public String toString() {
		return "RedacteurChercheur";
	}

}