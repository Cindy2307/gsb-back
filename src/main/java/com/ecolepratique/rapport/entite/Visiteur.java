package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
@DiscriminatorValue("VIS")
public class Visiteur extends Utilisateur{
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Rapport> rapports;

	
	public Visiteur() {
		super();
		rapports = new ArrayList<> ();
	}

	/**
	 * 
	 * @param login Identifiant du visiteur
	 * @param nom Nom du visiteur
	 * @param prenom Prénom du visiteur
	 * @param adresse Adresse du visiteur
	 * @param codePostal Code postal du visiteur
	 * @param ville Ville du visiteur
	 * @param dateNaissance Date de naissance du visiteur
	 */
	public Visiteur(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateNaissance) {
		super(login, nom, prenom, adresse, codePostal, ville, dateNaissance);
		rapports = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Visiteur [rapports=" + rapports + "]";
	}

	/**
	 * 
	 * @param rapport Rapport à ajouter
	 */
	public void addRapport(Rapport rapport) {
		rapports.add(rapport);
	}
	
	
	/**
	 * 
	 * @return Liste de rapports
	 */
	public List<Rapport> getRapports() {
		return rapports;
	}
	
	/**
	 * 
	 * @param rapports Liste de rapports saisis
	 */
	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}
}
