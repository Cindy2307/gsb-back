package com.ecolepratique.rapport.service;

import com.ecolepratique.rapport.entite.UserRole;

/**
 * 
 * @author Utilisateur
 *
 */
public interface UserRoleServiceItf {
	
	/**
	 * 
	 * @param login Identifiant de l'utilisateur
	 * @return Rôle de l'utilisateur
	 */
	UserRole getUserRoleById(String login);
}
