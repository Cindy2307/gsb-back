package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
public class Visiteur {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length = 30)
	@NotNull
	@Length(min=2, max=30, message="Le nom du visiteur doit être compris entre 2 et 30 caractères.")
	private String nom;
	@Column(nullable = false)
	private LocalDate dateEmbauche;
	@OneToMany
	private List<Rapport> rapports;
	public Visiteur() {
		rapports = new ArrayList<>();
	}
	public Visiteur(String nom, LocalDate dateEmbauche) {
		this.nom = nom;
		this.dateEmbauche = dateEmbauche;
		rapports = new ArrayList<>();
	}
	public void addRapport(Rapport rapport) {
		rapports.add(rapport);
	}
	
	@Override
	public String toString() {
		return "\nVisiteur [id=" + id + ", nom=" + nom + ", dateEmbauche=" + dateEmbauche + ", rapports=" + rapports
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public List<Rapport> getRapports() {
		return rapports;
	}
	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}
}
