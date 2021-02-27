package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.Medicament;

public interface MedicamentServiceItf {
	Medicament create(Medicament medicament);
	List<Medicament> list();
	Medicament getByNumDepotLegal(Long numDepotLegal);
	Medicament deleteByNumDepotLegal(Long numDepotLegal);
	Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament);
	List<Medicament> listByPage(int numPage, int taille);
	Medicament getByNomCommercial(String nomCommercial);
	List<Medicament> getByNomCommercialLike(String mc);
	List<Medicament> listOrderByNomCommercial();
	List<Medicament> getByNomCommercialLikeOrder(String nomCommercial);
}
