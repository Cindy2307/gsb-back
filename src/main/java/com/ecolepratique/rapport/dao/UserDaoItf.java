package com.ecolepratique.rapport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.User;

public interface UserDaoItf extends JpaRepository<User, String> {

}
