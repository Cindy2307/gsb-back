package com.ecolepratique.rapport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.UserRole;

public interface UserRoleDaoItf extends JpaRepository<UserRole, Long>{
	UserRole findByLogin(String login);
}
