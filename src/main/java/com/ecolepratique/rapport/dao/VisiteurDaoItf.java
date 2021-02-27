package com.ecolepratique.rapport.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Visiteur;

public interface VisiteurDaoItf extends JpaRepository<Visiteur, Long> {
	List<Visiteur> findByDateEmbaucheAfter(LocalDate date);
	List<Visiteur> findByDateEmbaucheBefore(LocalDate date);
}
