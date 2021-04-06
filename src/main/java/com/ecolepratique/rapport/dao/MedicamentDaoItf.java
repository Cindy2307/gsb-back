package com.ecolepratique.rapport.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Medicament;
/**
 * 
 * @author Christophe
 *
 */
public interface MedicamentDaoItf extends JpaRepository<Medicament, Long> {
	/**
	 * 
	 * @param nomCommercial Nom du medicament
	 * @return L'objet Medicament selon le nom commercial
	 */
	Medicament findByNomCommercial(String nomCommercial);
	
	/**
	 * 
	 * @param mc Mot contenu dans le nom commercial
	 * @return Une liste de noms de mediacments 
	 */
	List<Medicament> findByNomCommercialLike(String mc);
	
	/**
	 * 
	 * @return Liste de medicaments rangée par ordre alphabetique en fonction du nom commercial
	 */
	List<Medicament> findAllByOrderByNomCommercial();
	
	/**
	 * 
	 * @param mc Mot contenu dans le nom commericale
	 * @return Liste de nom commercial de medicament rangé par ordre alphabetique
	 */
	List<Medicament> findByNomCommercialLikeOrderByNomCommercial(String mc);
}
