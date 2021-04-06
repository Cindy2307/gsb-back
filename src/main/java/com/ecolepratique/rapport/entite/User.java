package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author Utilisateur
 *
 */
@Entity
public class User implements Serializable {
	
	@Id
	private String login;
	
	private String password;
	
	private boolean active;
	
	public User() {
		super();
	}
	
	/**
	 * 
	 * @param login Identifiant de l'utilisateur
	 * @param password Mot de passe de l'utilisateur
	 */
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = md5Pass(password);
		this.active = true;
	}
	
	/**
	 * 
	 * @param hashInput Mot de passe à encoder
	 * @return Mot de passe encodé
	 */
	private String md5Pass(String hashInput) {
		String hashedOutput = null;
		
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			hashedOutput = bCryptPasswordEncoder.encode(hashInput);
			/*MessageDigest messageDigest = MessageDigest.getInstance("MD4");
			byte[] data = hashInput.getBytes();
			byte[] hash = messageDigest.digest(data);
			hashedOutput = DatatypeConverter.printHexBinary(hash);*/			
		return hashedOutput;
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
	 * @return Mot de passe de l'utilisateur
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password Mot de passe saisi
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return Booléen qui indique si la session est active ou non
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * 
	 * @param active Booléen saisi
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", active=" + active + "]";
	}
}
