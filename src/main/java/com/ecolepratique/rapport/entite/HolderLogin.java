package com.ecolepratique.rapport.entite;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class HolderLogin {
	@NotEmpty(message="Le login ne peut être vide.")
	@NotNull(message="Le login ne peut être nul.")
	@Size(min=4, max=13, message="Le login doit contenir au minimum 4 caractères et au maximum 13 caractères.")
	private String login;
	@NotEmpty(message="Le mot de passe ne peut être vide.")
	@NotNull(message="Le mot de passe ne peut être nul.")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W|\\_])(?=\\S+$).{8,}$",
			 message="Le mot de passe doit contenir au moins 1 chiffre, une lettre minuscule, une lettre majuscule, un caractère spécial, aucun espace et doit faire au moins 8 caractères.")
	private String password;

	public HolderLogin() {
		super();
	}

	public HolderLogin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "HolderLogin [login=" + login + ", password=" + password + "]";
	}

}
