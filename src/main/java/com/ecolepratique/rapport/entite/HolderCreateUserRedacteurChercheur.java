package com.ecolepratique.rapport.entite;

public class HolderCreateUserRedacteurChercheur {
	private String password;
	private RedacteurChercheur redacteurChercheur;

	public HolderCreateUserRedacteurChercheur() {
		super();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RedacteurChercheur getRedacteurChercheur() {
		return redacteurChercheur;
	}

	public void setRedacteurChercheur(RedacteurChercheur redacteurChercheur) {
		this.redacteurChercheur = redacteurChercheur;
	}

}
