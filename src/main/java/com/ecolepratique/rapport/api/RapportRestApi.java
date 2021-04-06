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

import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.service.RapportServiceItf;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/rapport")
@CrossOrigin("*")
public class RapportRestApi {
	@Autowired
	private RapportServiceItf rapportService;
	
	/**
	 * 
	 * @return Liste de tous les rapports
	 */
	@GetMapping("")
	public List<Rapport> listRapport() {
		System.out.println("RapportRestApi - listRapport");
		return rapportService.listRapport();
	}
	
	/**
	 * 
	 * @param id Id d'un rapport
	 * @return Rapport contenant l'id
	 */
	@GetMapping("/{id}")
	public Rapport getRapportById(@PathVariable("id") Long id) {
		System.out.println("RapportRestApi - getRapportByVisiteur");
		return rapportService.findRapportById(id);
	}
	
	/**
	 * 
	 * @param id Id du rapport à modifier
	 * @param rapport Nouveau rapport dans le RequestBody
	 * @return Rapport modifié
	 */
	@PutMapping("/{id}")
	public Rapport update(@PathVariable("id") Long id, @Valid @RequestBody Rapport rapport) {
		return rapportService.updateRapport(id, rapport);
	}
	
	/**
	 * 
	 * @param id Id du rapport à supprimer
	 * @return Rapport supprimé
	 */
	@DeleteMapping("/{id}")
	public Rapport delete(@PathVariable("id") Long id) {
		return rapportService.deleteById(id);
	}
	
	/**
	 * 
	 * @param champ Champ contenant le mot clé
	 * @param motCle Mot clé spécifié par l'utilisateur
	 * @return Liste de rapports contenant le mot clé dans le champ précisé
	 */
	@GetMapping(
			params = {"champ", "motcle"}
	)
	public List<Rapport> listRapportByChampEtMotCle(@RequestParam("champ") String champ, @RequestParam("motcle") String motCle) {
		System.out.println("RapportRestApi - listRapportByChampEtMotCle");
		return rapportService.listRapportByChampEtMotCle(champ, motCle);
	}
	
	/**
	 * 
	 * @param date Date saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste des rapports écrits avant ou après la date saisie
	 */
	@GetMapping(
			params = {"date", "type"}
	)
	public List<Rapport> listRapportByDate(@RequestParam("date") String date, @RequestParam("type") String type) {
		System.out.println("RapportRestApi - listRapportAfterDate");
		return rapportService.listRapportByDate(date, type);
	}
	
	/**
	 * 
	 * @param idRapport Id du rapport auquel on veut ajouter une offre
	 * @param offre Offre qu'on veut ajouter au rapport
	 * @return Offre créée
	 */
	@PostMapping("/{id}/offre")
	public OffreEchantillon create(@PathVariable("id") Long idRapport, @RequestBody OffreEchantillon offre) {
        return rapportService.createOffreEchantillon(idRapport, offre);
	}	
}
