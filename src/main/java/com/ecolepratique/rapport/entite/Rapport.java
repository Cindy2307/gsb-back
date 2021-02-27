package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.sun.istack.NotNull;

@Entity
public class Rapport {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private LocalDate date;
	@Column(columnDefinition = "TEXT", nullable=false)
	@NotNull
	@NotEmpty(message="Le bilan ne doit pas être vide.")
	private String bilan;
	@Column(columnDefinition="TEXT", nullable=false)
	@NotNull
	@NotEmpty(message="Le bilan ne doit pas être vide.")
	private String motif;
	@OneToMany(fetch = FetchType.EAGER)
	private List<OffreEchantillon> offres;
	
	public Rapport() {
		offres = new ArrayList<>();
	}
	public Rapport(LocalDate date, String bilan, String motif) {
		this.date = date;
		this.bilan = bilan;
		this.motif = motif;
		offres = new ArrayList<>();
	}

	public void addOffre(OffreEchantillon offre) {
		offres.add(offre);
	}
	
	@Override
	public String toString() {
		return "Rapport [id=" + id + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", medicaments="
				+ offres + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getBilan() {
		return bilan;
	}
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public List<OffreEchantillon> getOffres() {
		return offres;
	}
	public void setOffres(List<OffreEchantillon> offres) {
		this.offres = offres;
	}
}
