package com.ecolepratique.rapport.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.rapport.entite.Medicament;
import com.ecolepratique.rapport.service.MedicamentServiceItf;

@RestController
@RequestMapping("/medicament")
@CrossOrigin("*")
public class MedicamentRestApi {
	@Autowired
	private MedicamentServiceItf medicamentService;
	
	@GetMapping("")
	public List<Medicament> list() {
		System.out.println("MedicamentRestApi - list()");
		List<Medicament> medicaments = medicamentService.list();
		return medicaments;
	}
	@GetMapping(
	    params = { "page", "size" }
	)
	public List<Medicament> listPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		System.out.println("MedicamentRestApi - list()");
		List<Medicament> pageMedicaments = medicamentService.listByPage(page, size);
		return pageMedicaments;
	}
	@GetMapping("/{id}")
	public Medicament get(@PathVariable("id") Long numDepotLegal) {
		System.out.println("MedicamentRestApi - get(id) ");
		return medicamentService.getByNumDepotLegal(numDepotLegal);
	}
	@PostMapping("")
	public Medicament create(@Valid @RequestBody Medicament medicament) {
        return medicamentService.create(medicament);
	}
	@PutMapping("/{id}")
	public Medicament update(@PathVariable("id") Long numDepotLegal, @Valid @RequestBody Medicament medicament) {
		return medicamentService.updateByNumDepotLegal(numDepotLegal, medicament);
	}
	@DeleteMapping("/{id}")
	public Medicament delete(@PathVariable("id") Long numDepotLegal) {
		return medicamentService.deleteByNumDepotLegal(numDepotLegal);
	}
	@GetMapping(
		params = "nom"
	)
	public Medicament getByNomCommercial(@RequestParam("nom") String nomCommercial) {
		System.out.println("getByNomCommercial - nomCommercial=" + nomCommercial);
		return medicamentService.getByNomCommercial(nomCommercial);
	}
	@GetMapping(
		params = "motcle"
	)
	public List<Medicament> getByNomCommercialLike(@RequestParam("motcle") String mc) {
		System.out.println("getByNomCommercialLike - mc=" + mc);
		return medicamentService.getByNomCommercialLike(mc);
	}
	@GetMapping(
		params = "trier"
	)
	public List<Medicament> getAllOrderByNomCommercial(@RequestParam("trier") String champ) {
		System.out.println("getAllOrderByNomCommercial");
		if(champ.equals("nom")) {
			return medicamentService.listOrderByNomCommercial();
		}
		return null;
	}
	@GetMapping(
		params = {"motcle", "trier"}
	)
	public List<Medicament> getByNomCommercialLikeOrder(@RequestParam("motcle") String mc, @RequestParam("trier") String champ) {
		System.out.println("getByNomCommercialLikeOrder - mc=" + mc);
		if(champ.equals("nom")) {
			return medicamentService.getByNomCommercialLikeOrder(mc);
		}
		return null;
	}
	
}
