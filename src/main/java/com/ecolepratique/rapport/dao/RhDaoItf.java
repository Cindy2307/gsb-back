package com.ecolepratique.rapport.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Utilisateur;

public interface RhDaoItf extends JpaRepository<Utilisateur, String>{
	List<Utilisateur> findByDateEmbaucheAfter(LocalDate date);
	List<Utilisateur> findByDateEmbaucheBefore(LocalDate date);
}
