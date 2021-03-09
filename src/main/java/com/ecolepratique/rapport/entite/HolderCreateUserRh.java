package com.ecolepratique.rapport.entite;

public class HolderCreateUserRh {
	private String password;
	private Rh rh;

	public HolderCreateUserRh() {
		super();
	}

	public HolderCreateUserRh(String password, Rh rh) {
		super();
		this.password = password;
		this.rh = rh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rh getRh() {
		return rh;
	}

	public void setRh(Rh rh) {
		this.rh = rh;
	}

	@Override
	public String toString() {
		return "HolderCreateUserRh [password=" + password + ", rh=" + rh + "]";
	}

}
