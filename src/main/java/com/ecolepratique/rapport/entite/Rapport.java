package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
public class Rapport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	@Column(columnDefinition = "TEXT", nullable=false)
	@NotNull(message="Le bilan ne doit pas être nul.")
	@NotEmpty(message="Le bilan ne doit pas être vide.")
	private String bilan;
	
	@Column(columnDefinition="TEXT", nullable=false)
	@NotNull(message="Le motif ne doit pas être nul.")
	@NotEmpty(message="Le motif ne doit pas être vide.")
	private String motif;
	
	public Rapport() {}
	
	/**
	 * 
	 * @param date Date du rapport
	 * @param bilan Bilan du rapport
	 * @param motif Motif du rapport
	 */
	public Rapport(LocalDate date, String bilan, String motif) {
		this.date = date;
		this.bilan = bilan;
		this.motif = motif;
	}

	
	@Override
	public String toString() {
		return "Rapport [id=" + id + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + "]";
	}
	
	/**
	 * 
	 * @return Id du rapport
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id Id saisi
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return date de création du rapport
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * 
	 * @param date Date du rapport saisie
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @return Bilan du rapport
	 */
	public String getBilan() {
		return bilan;
	}
	
	/**
	 * 
	 * @param bilan Bilan saisi
	 */
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}
	
	/**
	 * 
	 * @return Motif du rapport
	 */
	public String getMotif() {
		return motif;
	}
	
	/**
	 * 
	 * @param motif Motif saisi
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}
}
