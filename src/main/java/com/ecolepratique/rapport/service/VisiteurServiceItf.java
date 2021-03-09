package com.ecolepratique.rapport.service;

import java.util.List;
import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;

public interface VisiteurServiceItf {
	Visiteur createVisiteur(Visiteur visiteur, String password);
	Visiteur findVisiteurById(String id);
	Visiteur updateVisiteurByid(String id, Visiteur visiteur);
	Visiteur deleteVisiteurById(String id);
	Stream<Utilisateur> listVisiteur();
	Stream<Utilisateur> listVisiteurByDateEmbauche(String date, String type);
	
	List<Rapport> listRapportByIdVisiteur(String idVisiteur);
	Rapport createRapport(String idVisiteur, Rapport rapport);

}
