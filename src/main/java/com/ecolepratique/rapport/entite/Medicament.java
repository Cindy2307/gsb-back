package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
public class Medicament implements Serializable {
	
	@Id
	@GeneratedValue
	private Long numDepotLegal;
	
	@Column(length=50)
	@NotNull(message="Le nom du médicament ne peut être nul.")
	@NotEmpty(message="Le nom du médicament ne peut être vide.")
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
	
	/**
	 * 
	 * @param nomCommercial Nom du médicament
	 */
	public Medicament(String nomCommercial) {
		this();
		this.nomCommercial = nomCommercial;
	}
	
	/**
	 * 
	 * @param nomCommercial Nom du médicament
	 * @param effets Effets du médicament
	 * @param contreIndications Contre-indications du médicament
	 */
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
	
	/**
	 * 
	 * @param effet Effet à ajouter
	 */
	public void addEffet(String effet) {
		effets.add(effet);
	}
	
	/**
	 * 
	 * @param contreIndication Contre-indication à ajouter
	 */
	public void addContreIndication(String contreIndication) {
		contreIndications.add(contreIndication);
	}
	
	/**
	 * 
	 * @return Numéro de dépot légal du médicament
	 */
	public Long getNumDepotLegal() {
		return numDepotLegal;
	}
	
	/**
	 * 
	 * @param numDepotLegal Numéro de dépot légal saisi
	 */
	public void setNumDepotLegal(Long numDepotLegal) {
		this.numDepotLegal = numDepotLegal;
	}
	
	/**
	 * 
	 * @return Nom commercial du médicament
	 */
	public String getNomCommercial() {
		return nomCommercial;
	}
	
	/**
	 * 
	 * @param nomCommercial
	 */
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	
	/**
	 * 
	 * @return Liste d'effets du médicament
	 */
	public List<String> getEffets() {
		return effets;
	}
	
	/**
	 * 
	 * @param effets Liste d'effets saisis
	 */
	public void setEffets(List<String> effets) {
		this.effets = effets;
	}
	
	/**
	 * 
	 * @return Liste de contre-indications du médicament
	 */
	public List<String> getContreIndications() {
		return contreIndications;
	}
	
	/**
	 * Liste de contre-indications saisies
	 * @param contreIndications
	 */
	public void setContreIndications(List<String> contreIndications) {
		this.contreIndications = contreIndications;
	}	
}
