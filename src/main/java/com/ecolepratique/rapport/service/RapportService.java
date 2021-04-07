package com.ecolepratique.rapport.service;

import com.ecolepratique.rapport.dao.OffreEchantillonDaoItf;
import com.ecolepratique.rapport.dao.RapportDaoItf;
import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.entite.Rapport;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class RapportService implements RapportServiceItf {
	
	@Autowired
	private RapportDaoItf rapportDao;
	
	@Autowired
	private OffreEchantillonDaoItf offreDao;
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public Rapport findRapportById(Long id) {
		return rapportDao.findById(id).get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RC")
	@Override
	public List<Rapport> listRapport() {
		return rapportDao.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_VIS")
	@Override
	public Rapport updateRapport(Long id, Rapport rapport) {
		Rapport ancienRapport = findRapportById(id);
		rapport.setId(id);
		rapport.setDate(ancienRapport.getDate());
		rapport.setOffres(ancienRapport.getOffres());
		return rapportDao.save(rapport);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_VIS")
	@Override
	public Rapport deleteById(Long id) {
		Rapport rapport = findRapportById(id);
		rapportDao.deleteById(id);
		return rapport;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RC")
	@Override
	public List<Rapport> listRapportByChampEtMotCle(String champ, String motCle){
		List<Rapport> rapports = null;
		if(champ.equals("motif")){
			rapports = rapportDao.findByMotifLike("%" + motCle + "%");
		}
		else if(champ.equals("bilan")) {
			rapports = rapportDao.findByBilanLike("%" + motCle + "%");
		}
		return rapports;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_RC")
	@Override
	public List<Rapport> listRapportByDate(String date, String type){
		String[] tab = date.split("-"); 
		List<Rapport> rapports = null;
		if(type.equals("after"))
			rapports = rapportDao.findByDateAfter(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		else if(type.equals("before"))
			rapports = rapportDao.findByDateBefore(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		return rapports;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed("ROLE_VIS")
	@Override
	public OffreEchantillon createOffreEchantillon(Long idRapport, OffreEchantillon offre) {
		offre = offreDao.save(offre);
		Rapport rapport = findRapportById(idRapport);
		rapport.addOffre(offre);
		rapportDao.save(rapport);
		return offre;
	}
}
