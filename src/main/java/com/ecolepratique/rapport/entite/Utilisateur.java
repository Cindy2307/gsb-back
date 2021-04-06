package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_UTI")
public abstract class Utilisateur implements Serializable{
	
	@Id
	@Column(nullable = false, length = 30)
	@NotEmpty(message="Le login ne peut être vide")
	@NotNull(message="Le login ne peut être nul")
	@Size(min=4, max=13, message="Le login doit contenir au minimum 4 caractères et au maximum 13 caractères")
	private String login;
	
	@Column(nullable = false, length = 30)
	@NotEmpty(message="Le nom ne peut être vide")
	@NotNull(message="Le nom ne peut être nul")
	@Size(min=2, max=20, message="Le nom doit contenir au minimum 2 caractères et au maximum 20 caractères")
	private String nom;
	
	@Column(nullable = false, length = 30)
	@NotEmpty(message="Le prénom ne peut être vide")
	@NotNull(message="Le prénom ne peut être nul")
	@Size(min=2, max=20, message="Le prénom doit contenir au minimum 2 caractères et au maximum 20 caractères")
	private String prenom;
	
	@Column(nullable = false, length = 255)
	@NotEmpty(message="L'adresse ne peut être vide")
	@NotNull(message="L'adresse ne peut être vide")
	private String adresse;
	
	@Column(nullable = false)
	@NotNull(message="Le code postal ne peut être nul")
	private int codePostal;
	
	@Column(nullable = false, length = 100)
	@NotEmpty(message="La ville ne peut être vide")
	@NotNull(message="La ville ne peut être nulle")
	@Size(min=3, max=50, message="La ville doit contenir au minimum 3 caractères et au maximum 50 caractères")
	private String ville;
	
	@Column(nullable = false)
	@NotNull(message="La date de naissance ne peut être nulle")
	@Past(message="La date de naissance doit être postérieure à la date du jour")
	private LocalDate dateNaissance;
	
	private LocalDate dateEmbauche;
	
	public Utilisateur() {}
	/**
	 * 
	 * @param login Identifiant de l'utilisateur
	 * @param nom Nom de l'utilisateur
	 * @param prenom Prénom de l'utilisateur
	 * @param adresse Adresse de l'utilisateur
	 * @param codePostal Code postal de l'utilisateur
	 * @param ville Ville de l'utilisateur
	 * @param dateNaissance Date de naissance de l'utilisateur
	 */
	public Utilisateur(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateNaissance) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", dateNaissance=" + dateNaissance
				+ ", dateEmbauche=" + dateEmbauche + "]";
	}
	
	/**
	 * 
	 * @return Nom de l'utilisateur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom Nom saisi
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return Identifiant de l'utilisateur
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * 
	 * @param login Identifiant saisi
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * 
	 * @return Prénom de l'utilisateur
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * 
	 * @param prenom Prénom saisi
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * 
	 * @return Adresse de l'utilisateur
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * 
	 * @param adresse Adresse saisie
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * 
	 * @return Code postal de l'utilisateur
	 */
	public int getCodePostal() {
		return codePostal;
	}
	
	/**
	 * 
	 * @param codePostal Code postal saisi
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * 
	 * @return Ville de l'utilisateur
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * 
	 * @param ville Ville saisie
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * 
	 * @return Date d'embauche de l'utilisateur
	 */
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	
	/**
	 * 
	 * @param dateEmbauche Date d'embauche saisie
	 */
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	/**
	 * 
	 * @return Date de naissance de l'utilisateur
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	/**
	 * 
	 * @param dateNaissance Date de naissance saisie
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
}

