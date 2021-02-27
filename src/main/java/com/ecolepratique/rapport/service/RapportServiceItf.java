package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.entite.Rapport;

public interface RapportServiceItf {
	List<Rapport> listRapport();
	Rapport findRapportById(Long id);
	Rapport updateRapport(Long id, Rapport rapport);
	Rapport deleteById(Long id);
	List<Rapport> listRapportByChampEtMotCle(String champ, String motCle);
	List<Rapport> listRapportByDate(String date, String type);
	
	OffreEchantillon createOffreEchantillon(Long idRapport, OffreEchantillon offre);
}
