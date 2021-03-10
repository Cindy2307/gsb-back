package com.ecolepratique.rapport.service;

import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Utilisateur;

public interface RedacteurChercheurServiceItf {
	RedacteurChercheur createRedacteurChercheur(RedacteurChercheur redacteurChercheur, String password);
	RedacteurChercheur findRedacteurChercheurById(String id);
	RedacteurChercheur updateRedacteurChercheurByid(String id, RedacteurChercheur redacteurChercheur);
	RedacteurChercheur deleteRedacteurChercheurById(String id);
	Stream<Utilisateur> listRedacteurChercheur();
	Stream<Utilisateur> listRedacteurChercheurByDateEmbauche(String date, String type);
}
