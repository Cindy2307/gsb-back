package com.ecolepratique.rapport.service;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.entite.UserRole;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class UserRoleService implements UserRoleServiceItf{

	@Autowired
	private UserRoleDaoItf userRoleDao;
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_RH", "ROLE_VIS", "ROLE_RC"})
	@Override
	public UserRole getUserRoleById(String login) {
		return userRoleDao.findByLogin(login);
	}
	
}
