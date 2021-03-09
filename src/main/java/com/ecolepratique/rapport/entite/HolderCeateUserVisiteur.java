package com.ecolepratique.rapport.entite;

public class HolderCeateUserVisiteur {
	private String password;
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
