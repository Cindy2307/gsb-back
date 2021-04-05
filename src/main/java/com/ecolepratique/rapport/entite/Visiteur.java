package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("VIS")
public class Visiteur extends Utilisateur{
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Rapport> rapports;

	
	public Visiteur() {
		super();
		rapports = new ArrayList<> ();
	}

	public Visiteur(String login, String nom, String prenom, String adresse,
			int codePostal, String ville, LocalDate dateNaissance) {
		super(login, nom, prenom, adresse, codePostal, ville, dateNaissance);
		rapports = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Visiteur [rapports=" + rapports + "]";
	}

	public void addRapport(Rapport rapport) {
		rapports.add(rapport);
	}
	
	public List<Rapport> getRapports() {
		return rapports;
	}
	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}
}
