package com.ecolepratique.rapport.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User implements Serializable {
	@Id
	private String login;
	private String password;
	private boolean active;
	public User() {
		super();
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = md5Pass(password);
		this.active = true;
	}
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", active=" + active + "]";
	}
}
