package com.ecolepratique.rapport.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
	public static String getLogin() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	/*
	public static C getRole() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}*/
	public static String tabIntToString(int tab[]) {
		String str = null;
		for (int i = 0; i < tab.length; i++) {
			str += tab[i] + " ";
		}
		return str;
	}
	public static String tabLongToString(Long tab[]) {
		String str = null;
		for (int i = 0; i < tab.length; i++) {
			str += tab[i] + " ";
		}
		return str;
	}
}
