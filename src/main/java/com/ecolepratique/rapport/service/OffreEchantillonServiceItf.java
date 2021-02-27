package com.ecolepratique.rapport.service;

import java.util.List;
import com.ecolepratique.rapport.entite.OffreEchantillon;

public interface OffreEchantillonServiceItf {
	OffreEchantillon findOffreEchantillonById(Long id);
	OffreEchantillon updateOffreEchantillonByid(Long id, OffreEchantillon offre);
	OffreEchantillon deleteOffreEchantillon(Long id);
	List<OffreEchantillon> listOffreEchantillon();
}
