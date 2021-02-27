package com.ecolepratique.rapport.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.dao.OffreEchantillonDaoItf;
import com.ecolepratique.rapport.entite.OffreEchantillon;

@Service
public class OffreEchantillonService implements OffreEchantillonServiceItf{
	@Autowired
	private OffreEchantillonDaoItf offreDao;

	@Override
	public OffreEchantillon findOffreEchantillonById(Long id) {
		return offreDao.findById(id).get();
	}

	@Override
	public OffreEchantillon updateOffreEchantillonByid(Long id, OffreEchantillon offre) {
		OffreEchantillon ancienneOffre = findOffreEchantillonById(id);
		offre.setId(id);
		offre.setMedicament(ancienneOffre.getMedicament());;
		return offreDao.save(offre);
	}

	@Override
	public OffreEchantillon deleteOffreEchantillon(Long id) {
		OffreEchantillon offre = findOffreEchantillonById(id);
		offreDao.deleteById(id);
		return offre;
	}

	@Override
	public List<OffreEchantillon> listOffreEchantillon() {
		return offreDao.findAll();
	}

}
