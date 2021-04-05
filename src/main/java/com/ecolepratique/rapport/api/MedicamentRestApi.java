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

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/medicament")
@CrossOrigin("*")
public class MedicamentRestApi {
	
	@Autowired
	private MedicamentServiceItf medicamentService;
	
	/**
	 * 
	 * @return Liste de tous les médicaments
	 */
	@GetMapping("")
	public List<Medicament> list() {
		System.out.println("MedicamentRestApi - list()");
		List<Medicament> medicaments = medicamentService.list();
		return medicaments;
	}
	
	/**
	 * 
	 * @param page Numéro de la page
	 * @param size Nombre de médicaments dans la page
	 * @return Liste des médicaments sur une page
	 */
	@GetMapping(
	    params = { "page", "size" }
	)
	public List<Medicament> listPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		System.out.println("MedicamentRestApi - list()");
		List<Medicament> pageMedicaments = medicamentService.listByPage(page, size);
		return pageMedicaments;
	}
	
	/**
	 * 
	 * @param numDepotLegal Id du médicament
	 * @return Médicament en fonction de son id
	 */
	@GetMapping("/{id}")
	public Medicament get(@PathVariable("id") Long numDepotLegal) {
		System.out.println("MedicamentRestApi - get(id) ");
		return medicamentService.getByNumDepotLegal(numDepotLegal);
	}
	
	/**
	 * 
	 * @param medicament Médicament entré dans le body de la requête
	 * @return Médicament créé
	 */
	@PostMapping("")
	public Medicament create(@Valid @RequestBody Medicament medicament) {
        return medicamentService.create(medicament);
	}
	
	/**
	 * 
	 * @param numDepotLegal Id du médicament à modifier
	 * @param medicament Médicament entré dans le body de la requête
	 * @return Médicament modifié
	 */
	@PutMapping("/{id}")
	public Medicament update(@PathVariable("id") Long numDepotLegal, @Valid @RequestBody Medicament medicament) {
		return medicamentService.updateByNumDepotLegal(numDepotLegal, medicament);
	}
	
	/**
	 * 
	 * @param numDepotLegal Id du médicament à supprimer
	 * @return Médicament supprimé
	 */
	@DeleteMapping("/{id}")
	public Medicament delete(@PathVariable("id") Long numDepotLegal) {
		return medicamentService.deleteByNumDepotLegal(numDepotLegal);
	}
	
	/**
	 * 
	 * @param nomCommercial Nom du médicament
	 * @return Médicament qui porte le nom commercial entré par l'utilisateur
	 */
	@GetMapping(
		params = "nom"
	)
	public Medicament getByNomCommercial(@RequestParam("nom") String nomCommercial) {
		System.out.println("getByNomCommercial - nomCommercial=" + nomCommercial);
		return medicamentService.getByNomCommercial(nomCommercial);
	}
	
	/**
	 * 
	 * @param mc Mot clé entré par l'utilisateur
	 * @return Liste des médicaments dont le nom commercial contient ce mot clé
	 */
	@GetMapping(
		params = "motcle"
	)
	public List<Medicament> getByNomCommercialLike(@RequestParam("motcle") String mc) {
		System.out.println("getByNomCommercialLike - mc=" + mc);
		return medicamentService.getByNomCommercialLike(mc);
	}
	
	/**
	 * 
	 * @param champ Champ entré par l'utilisateur
	 * @return Liste des médicaments triés en fonction du champ demandé
	 */
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
	
	/**
	 * 
	 * @param mc Mot clé entré par l'utilisateur
	 * @param champ Champ entré par l'utilisateur
	 * @return Liste des médicaments contenant ce mot clé triés en fonction du champ entré par l'utilisateur
	 */
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
