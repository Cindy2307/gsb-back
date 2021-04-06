package com.ecolepratique.rapport.entite;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author Utilisateur
 *
 */
public class HolderCreateUserRedacteurChercheur {
	
	@Column(nullable = false)
	@NotEmpty(message="Le mot de passe ne peut être vide.")
	@NotNull(message="Le mot de passe ne peut être nul.")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W|\\_])(?=\\S+$).{8,}$",
			 message="Le mot de passe doit contenir au moins 1 chiffre, une lettre minuscule, une lettre majuscule, un caractère spécial, aucun espace et doit faire au moins 8 caractères.")
	private String password;
	
	@Valid
	private RedacteurChercheur redacteurChercheur;

	public HolderCreateUserRedacteurChercheur() {
		super();
	}

	/**
	 * 
	 * @param password Mot de passe du rédacteur/chercheur
	 * @param redacteurChercheur Rédacteur/Chercheur saisi
	 */
	public HolderCreateUserRedacteurChercheur(String password, RedacteurChercheur redacteurChercheur) {
		super();
		this.password = password;
		this.redacteurChercheur = redacteurChercheur;
	}

	@Override
	public String toString() {
		return "HolderCreateUserRedacteurChercheur [password=" + password + ", redacteurChercheur=" + redacteurChercheur
				+ "]";
	}

	/**
	 * 
	 * @return Mot de passe du rédacteur/chercheur
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password Mot de passe saisi
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return Rédacteur/chercheur
	 */
	public RedacteurChercheur getRedacteurChercheur() {
		return redacteurChercheur;
	}

	/**
	 * 
	 * @param redacteurChercheur Rédacteur/Chercheur saisi
	 */
	public void setRedacteurChercheur(RedacteurChercheur redacteurChercheur) {
		this.redacteurChercheur = redacteurChercheur;
	}

}
