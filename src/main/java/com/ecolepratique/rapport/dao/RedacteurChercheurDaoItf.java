package com.ecolepratique.rapport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Utilisateur;

public interface RedacteurChercheurDaoItf  extends JpaRepository<Utilisateur, String>{

}