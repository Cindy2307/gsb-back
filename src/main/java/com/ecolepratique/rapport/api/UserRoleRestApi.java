package com.ecolepratique.rapport.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.service.UserRoleServiceItf;
import com.ecolepratique.rapport.util.Utils;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class UserRoleRestApi {
	@Autowired
	private UserRoleServiceItf userRoleService;
	
	/**
	 * 
	 * @return Rôle de l'utilisateur
	 */
	@GetMapping("")
	public UserRole login() {
		String login = Utils.getLogin();
        return userRoleService.getUserRoleById(login);
	}
}
