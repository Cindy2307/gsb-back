package com.ecolepratique.rapport.entite;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class HolderCreateUserRh {
	@Column(nullable = false)
	@NotEmpty(message="Le mot de passe ne peut être vide.")
	@NotNull(message="Le mot de passe ne peut être nul.")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W|\\_])(?=\\S+$).{8,}$",
			 message="Le mot de passe doit contenir au moins 1 chiffre, une lettre minuscule, une lettre majuscule, un caractère spécial, aucun espace et doit faire au moins 8 caractères.")
	private String password;
	@Valid
	private Rh rh;

	public HolderCreateUserRh() {
		super();
	}

	public HolderCreateUserRh(String password, Rh rh) {
		super();
		this.password = password;
		this.rh = rh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rh getRh() {
		return rh;
	}

	public void setRh(Rh rh) {
		this.rh = rh;
	}

	@Override
	public String toString() {
		return "HolderCreateUserRh [password=" + password + ", rh=" + rh + "]";
	}

}
