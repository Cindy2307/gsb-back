package com.ecolepratique.rapport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Utilisateur;

/**
 * 
 * @author Christophe
 *
 */
public interface UtilisateurDaoItf extends JpaRepository<Utilisateur, String>{

}
