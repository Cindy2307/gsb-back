package com.ecolepratique.rapport.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.service.OffreEchantillonServiceItf;

@RestController
@RequestMapping("/offre")
@CrossOrigin("*")
public class OffreRestApi {
	@Autowired
	private OffreEchantillonServiceItf offreService;
	
	@GetMapping("")
	public List<OffreEchantillon> listRapport() {
		System.out.println("OffreRestApi - listOffre");
		return offreService.listOffreEchantillon();
	}
	@GetMapping("/{id}")
	public OffreEchantillon getOffreEchantillonById(@PathVariable("id") Long id) {
		System.out.println("OffreRestApi - getOffreById");
		return offreService.findOffreEchantillonById(id);
	}	
	@PutMapping("/{id}")
	public OffreEchantillon update(@PathVariable("id") Long id, @Valid @RequestBody OffreEchantillon offre) {
		return offreService.updateOffreEchantillonByid(id, offre);
	}
	@DeleteMapping("/{id}")
	public OffreEchantillon delete(@PathVariable("id") Long id) {
		return offreService.deleteOffreEchantillon(id);
	}
}
