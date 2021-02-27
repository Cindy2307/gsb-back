package com.ecolepratique.rapport.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Medicament;

public interface MedicamentDaoItf extends JpaRepository<Medicament, Long> {
	Medicament findByNomCommercial(String nomCommercial);
	List<Medicament> findByNomCommercialLike(String mc);
	List<Medicament> findAllByOrderByNomCommercial();
	List<Medicament> findByNomCommercialLikeOrderByNomCommercial(String mc);
}
