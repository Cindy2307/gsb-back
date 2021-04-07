package com.ecolepratique.rapport.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * @author Utilisateur
 *
 */
public class Utils {
	
	/**
	 * 
	 * @return Identifiant de l'utilisateur
	 */
	public static String getLogin() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
