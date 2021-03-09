package com.ecolepratique.rapport.service;

import java.util.stream.Stream;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.Utilisateur;

public interface RhServiceItf {
	Rh createRh(Rh rh, String password);
	Rh findRhById(String id);
	Rh updateRhByid(String id, Rh rh);
	Rh deleteRhById(String id);
	Stream<Utilisateur> listRh();
}
