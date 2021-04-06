package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
public class UserRole implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String login;
	
	private String role;
	
	public UserRole() {
		super();
	}
	
	/**
	 * 
	 * @param login Identifiant de l'utilisateur
	 * @param role Rôle de l'utilisateur
	 */
	public UserRole(String login, String role) {
		super();
		this.login = login;
		this.role = role;
	}
	
	/**
	 * 
	 * @return Id de l'utilisateur
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id Id saisi
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return Identifiant de l'utilisateur
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * 
	 * @param login Identifiant saisi
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * 
	 * @return Rôle de l'utilisateur
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * 
	 * @param role Rôle saisi
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "user_role [login=" + login + ", role=" + role + "]";
	}
	
}
