package com.ecolepratique.rapport.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class OffreEchantillon {
	@Id
	@GeneratedValue
	private Long id;
	@Min(1)@Max(10)
	private int quantite;
	@OneToOne
	private Medicament medicament;
	
	public OffreEchantillon() {}
	public OffreEchantillon(int quantite, Medicament medicament) {
		this.quantite = quantite;
		this.medicament = medicament;
	}

	@Override
	public String toString() {
		return "OffreEchantillon [id=" + id + ", quantite=" + quantite + ", medicament=" + medicament + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

}
