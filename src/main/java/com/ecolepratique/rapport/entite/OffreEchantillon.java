package com.ecolepratique.rapport.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
public class OffreEchantillon {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Max(10)
	private int quantite;
	
	@ManyToOne
	private Medicament medicament;
	
	public OffreEchantillon() {}
	
	/**
	 * 
	 * @param quantite Quantité donnée
	 * @param medicament Médicament donné
	 */
	public OffreEchantillon(int quantite, Medicament medicament) {
		this.quantite = quantite;
		this.medicament = medicament;
	}

	@Override
	public String toString() {
		return "OffreEchantillon [id=" + id + ", quantite=" + quantite + ", medicament=" + medicament + "]";
	}
	
	/**
	 * 
	 * @return Id de l'offre
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
	 * @return Quantité d'échantillons donnés
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * 
	 * @param quantite Quantité saisie
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	/**
	 * 
	 * @return Médicament qui concerne l'offre
	 */
	public Medicament getMedicament() {
		return medicament;
	}
	
	/**
	 * 
	 * @param medicament Médicament saisi
	 */
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

}
