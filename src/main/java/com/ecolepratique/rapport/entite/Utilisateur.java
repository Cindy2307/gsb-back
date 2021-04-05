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
 * Classe Utilisateur
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
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
}

