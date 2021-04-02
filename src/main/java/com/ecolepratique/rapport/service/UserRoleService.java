package com.ecolepratique.rapport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.entite.UserRole;

@Service
public class UserRoleService implements UserRoleServiceItf{

	@Autowired
	private UserRoleDaoItf userRoleDao;
	
	@Override
	public String getUserRoleById(String login) {
		UserRole role = userRoleDao.findByLogin(login);
		return role.getRole();
	}
	
}
