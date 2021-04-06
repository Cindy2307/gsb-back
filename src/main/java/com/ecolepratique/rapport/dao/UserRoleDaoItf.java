package com.ecolepratique.rapport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.UserRole;

/**
 * 
 * @author Christophe
 *
 */
public interface UserRoleDaoItf extends JpaRepository<UserRole, Long>{
	/**
	 * 
	 * @param login login de l'utilisateur
	 * @return Objet UserRole selon le login
	 */
	UserRole findByLogin(String login);
}
