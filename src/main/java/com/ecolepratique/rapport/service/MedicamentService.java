package com.ecolepratique.rapport.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.ecolepratique.rapport.entite.Medicament;
import com.ecolepratique.rapport.dao.MedicamentDaoItf;

@Service
public class MedicamentService implements MedicamentServiceItf {
	@Autowired
	private MedicamentDaoItf medicamentDao;
	
	@Override
	public List<Medicament> list() {
		return medicamentDao.findAll();
	}
	@Override
	public Medicament create(Medicament medicament) {
		return medicamentDao.save(medicament);
	}
	@Override
	public Medicament getByNumDepotLegal(Long numDepotLegal) {
		return medicamentDao.findById(numDepotLegal).get();
	}
	@Override
	public Medicament deleteByNumDepotLegal(Long numDepotLegal) {
		Medicament medicament = getByNumDepotLegal(numDepotLegal);
		medicamentDao.deleteById(numDepotLegal);
		return medicament;
	}
	
	@Override
	public Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament) {
		medicament.setNumDepotLegal(numDepotLegal);
		return medicamentDao.save(medicament);
	}
	@Override
	public List<Medicament> listByPage(int numPage, int taille) {
		return medicamentDao.findAll(PageRequest.of(numPage,taille)).getContent();
	}
	@Override
	public Medicament getByNomCommercial(String nomCommercial) {
		return medicamentDao.findByNomCommercial(nomCommercial);
	}
	@Override
	public List<Medicament> getByNomCommercialLike(String mc) {
		return medicamentDao.findByNomCommercialLike("%"+mc+"%");
	}
	@Override
	public List<Medicament> listOrderByNomCommercial() {
		return medicamentDao.findAllByOrderByNomCommercial();
	}
	@Override
	public List<Medicament> getByNomCommercialLikeOrder(String mc){
		return medicamentDao.findByNomCommercialLikeOrderByNomCommercial("%"+mc+"%");
	}
}
