package com.ecolepratique.rapport.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.entite.Medicament;
import com.ecolepratique.rapport.dao.MedicamentDaoItf;

/**
 * 
 * @author Utilisateur
 *
 */
@Service
public class MedicamentService implements MedicamentServiceItf {
	
	@Autowired
	private MedicamentDaoItf medicamentDao;
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public List<Medicament> list() {
		return medicamentDao.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Medicament create(Medicament medicament) {
		return medicamentDao.save(medicament);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public Medicament getByNumDepotLegal(Long numDepotLegal) {
		return medicamentDao.findById(numDepotLegal).get();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Medicament deleteByNumDepotLegal(Long numDepotLegal) {
		Medicament medicament = getByNumDepotLegal(numDepotLegal);
		medicamentDao.deleteById(numDepotLegal);
		return medicament;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament) {
		medicament.setNumDepotLegal(numDepotLegal);
		return medicamentDao.save(medicament);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public List<Medicament> listByPage(int numPage, int taille) {
		return medicamentDao.findAll(PageRequest.of(numPage,taille)).getContent();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public Medicament getByNomCommercial(String nomCommercial) {
		return medicamentDao.findByNomCommercial(nomCommercial);
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public List<Medicament> getByNomCommercialLike(String mc) {
		return medicamentDao.findByNomCommercialLike("%"+mc+"%");
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public List<Medicament> listOrderByNomCommercial() {
		return medicamentDao.findAllByOrderByNomCommercial();
	}

	/**
	 * {@inheritDoc}
	 */
	@RolesAllowed({"ROLE_VIS", "ROLE_RC"})
	@Override
	public List<Medicament> getByNomCommercialLikeOrder(String mc){
		return medicamentDao.findByNomCommercialLikeOrderByNomCommercial("%"+mc+"%");
	}
}
