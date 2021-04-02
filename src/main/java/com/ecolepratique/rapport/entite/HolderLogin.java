package com.ecolepratique.rapport.entite;

public class HolderLogin {
	private String login;
	private String password;

	public HolderLogin() {
		super();
	}

	public HolderLogin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "HolderLogin [login=" + login + ", password=" + password + "]";
	}

}
