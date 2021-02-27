package com.ecolepratique.rapport.service;

import com.ecolepratique.rapport.dao.RapportDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Visiteur;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisiteurService implements VisiteurServiceItf {
	@Autowired
	private VisiteurDaoItf visiteurDao;
	@Autowired
	private RapportDaoItf rapportDao;
	
	@Override
	public Visiteur createVisiteur(Visiteur visiteur) {
		visiteur.setDateEmbauche(LocalDate.now());
		return visiteurDao.save(visiteur);
	}
	@Override
	public List<Visiteur> listVisiteur() {
		return visiteurDao.findAll();
	}
	@Override
	public Visiteur findVisiteurById(Long id) {
		return visiteurDao.findById(id).get();
	}
	@Override
	public Visiteur updateVisiteurByid(Long id, Visiteur visiteur) {
		Visiteur ancienVisiteur = findVisiteurById(id);
		visiteur.setId(id);
		visiteur.setDateEmbauche(ancienVisiteur.getDateEmbauche());
		visiteur.setRapports(ancienVisiteur.getRapports());
		return visiteurDao.save(visiteur);
	}
	@Override
	public Visiteur deleteVisiteurById(Long id) {
		Visiteur visiteur = findVisiteurById(id);
		for (Rapport rapport : visiteur.getRapports()) {
			rapportDao.deleteById(rapport.getId());
		}
		visiteurDao.deleteById(id);
		return visiteur;
	}
	@Override
	public Rapport createRapport(Long idVisiteur, Rapport rapport) {
		rapport.setDate(LocalDate.now());
		rapport = rapportDao.save(rapport);
		Visiteur visiteur = findVisiteurById(idVisiteur);
		visiteur.addRapport(rapport);
		visiteurDao.save(visiteur);
		return rapport;
	}
	@Override
	public List<Rapport> listRapportByIdVisiteur(Long idVisiteur) {
		return findVisiteurById(idVisiteur).getRapports();
	}
	@Override
	public List<Visiteur> listVisiteurByDateEmbauche(String date, String type) {
		String[] tab = date.split("-"); 
		List<Visiteur> visiteurs = null;
		if(type.equals("after"))
			visiteurs = visiteurDao.findByDateEmbaucheAfter(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		else if(type.equals("before"))
			visiteurs = visiteurDao.findByDateEmbaucheBefore(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		return visiteurs;
	}
	
}
