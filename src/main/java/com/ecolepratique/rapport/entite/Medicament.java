package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
public class Medicament implements Serializable {
	@Id
	@GeneratedValue
	private Long numDepotLegal;
	@Column(length=50)
	@NotNull
	@Length(min=2, max=30, message="Le nom du médicament doit être compris entre 2 et 30 caractères.")
	private String nomCommercial;
	@ElementCollection
	private List<String> effets;
	@ElementCollection
	private List<String> contreIndications;
	public Medicament() {
		effets = new ArrayList<>();
		contreIndications = new ArrayList<>();
	}
	public Medicament(String nomCommercial) {
		this();
		this.nomCommercial = nomCommercial;
	}
	public Medicament(String nomCommercial, List<String> effets, List<String> contreIndications) {
		this.nomCommercial = nomCommercial;
		this.effets = effets;
		this.contreIndications = contreIndications;
	}
	@Override
	public String toString() {
		return "Medicament [numDepotLegal=" + numDepotLegal + ", nomCommercial=" + nomCommercial + ", effets=" + effets
				+ ", contreIndications=" + contreIndications + "]\n\n";
	}
	public void addEffet(String effet) {
		effets.add(effet);
	}
	public void addContreIndication(String contreIndication) {
		contreIndications.add(contreIndication);
	}
	public Long getNumDepotLegal() {
		return numDepotLegal;
	}
	public void setNumDepotLegal(Long numDepotLegal) {
		this.numDepotLegal = numDepotLegal;
	}
	public String getNomCommercial() {
		return nomCommercial;
	}
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	public List<String> getEffets() {
		return effets;
	}
	public void setEffets(List<String> effets) {
		this.effets = effets;
	}
	public List<String> getContreIndications() {
		return contreIndications;
	}
	public void setContreIndications(List<String> contreIndications) {
		this.contreIndications = contreIndications;
	}	
}
