package com.ecolepratique.rapport.api;

import java.util.List;
import java.util.stream.Stream;

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
import com.ecolepratique.rapport.entite.HolderCeateUserVisiteur;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.VisiteurServiceItf;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/visiteur")
@CrossOrigin("*")
public class VisiteurRestApi {
	@Autowired
	private VisiteurServiceItf visiteurService;
	
	/**
	 * 
	 * @return Liste de tous les visiteurs
	 */
	@GetMapping("")
	public Stream<Utilisateur> listVisiteur() {
		System.out.println("RapportRestApi - listVisteur");
		Stream<Utilisateur> visiteurs = visiteurService.listVisiteur();
		System.out.println("VisiteurRestApi - listVisteur visiteurs=" + visiteurs);
		return visiteurs;
	}
	
	/**
	 * 
	 * @param id Id du visiteur recherché
	 * @return Visiteur contenant l'id recherché
	 */
	@GetMapping("/{id}")
	public Visiteur getVisiteur(@PathVariable("id") String id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return visiteurService.findVisiteurById(id);
	}
	
	/**
	 * 
	 * @param holder Objet contenant le mot de passe et le visiteur que l'on souhaite créer
	 * @return Visiteur créé
	 */
	@PostMapping("")
	public Visiteur createVisiteur(@Valid @RequestBody HolderCeateUserVisiteur holder) {
		System.out.println("VisiteurRestApi - create visiteur=" + holder);
        return visiteurService.createVisiteur(holder.getVisiteur(), holder.getPassword());
	}
	
	/**
	 * 
	 * @param id Id du visiteur à modifier
	 * @param visiteur Nouveau visiteur dans le RequestBody
	 * @return Visiteur modifié
	 */
	@PutMapping("/{id}")
	public Visiteur updateVisiteur(@PathVariable("id") String id,@Valid @RequestBody Visiteur visiteur) {
		return visiteurService.updateVisiteurByid(id, visiteur);
	}
	
	/**
	 * 
	 * @param id Id du visiteur à supprimer
	 * @return Visiteur supprimé
	 */
	@DeleteMapping("/{id}")
	public Visiteur deleteVisiteur(@PathVariable("id") String id) {
		return visiteurService.deleteVisiteurById(id);
	}
	
	/**
	 * 
	 * @param idVisiteur Id du visiteur dont on souhaite afficher les rapports
	 * @return Rapports du visiteur
	 */
	@GetMapping("/{id}/rapport")
	public List<Rapport> listRapportByIdVisiteur(@PathVariable("id") String idVisiteur) {
		System.out.println("VisiteurRestApi - getRapportByVisiteur");
		return visiteurService.listRapportByIdVisiteur(idVisiteur);
	}
	
	/**
	 * 
	 * @param idVisiteur Id du visiteur pour lequel on souhaite créer un rapport
	 * @param rapport Rapport à créer
	 * @return Rapport créé
	 */
	@PostMapping("/{id}/rapport")
	public Rapport create(@PathVariable("id") String idVisiteur,@Valid @RequestBody Rapport rapport) {
        return visiteurService.createRapport(idVisiteur, rapport);
	}
	
	/**
	 * 
	 * @param date Date saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste des visiteurs embauchés avant ou après la date saisie
	 */
	@GetMapping(
			params = {"date", "type"}
	)
	public Stream<Utilisateur> listVisiteurEmbaucheByDate(@RequestParam("date") String date, @RequestParam("type") String type) {
		return visiteurService.listVisiteurByDateEmbauche(date, type);
	}
}
