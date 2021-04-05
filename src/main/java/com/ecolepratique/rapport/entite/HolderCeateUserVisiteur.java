package com.ecolepratique.rapport.entite;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class HolderCeateUserVisiteur {
	@Column(nullable = false)
	@NotEmpty(message="Le mot de passe ne peut être vide.")
	@NotNull(message="Le mot de passe ne peut être nul.")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W|\\_])(?=\\S+$).{8,}$",
			 message="Le mot de passe doit contenir au moins 1 chiffre, une lettre minuscule, une lettre majuscule, un caractère spécial, aucun espace et doit faire au moins 8 caractères.")
	private String password;
	@Valid
	private Visiteur visiteur;

	public HolderCeateUserVisiteur() {
		super();
	}

	public HolderCeateUserVisiteur(String password, Visiteur visiteur) {
		super();
		this.password = password;
		this.visiteur = visiteur;
	}

	@Override
	public String toString() {
		return "Holder [password=" + password + ", visiteur=" + visiteur + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

}
