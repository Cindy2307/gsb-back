package com.ecolepratique.rapport.api;

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
import com.ecolepratique.rapport.entite.HolderCreateUserRh;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.service.RhServiceItf;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/rh")
@CrossOrigin("*")
public class RhRestApi {
	@Autowired
	private RhServiceItf rhService;

	/**
	 * 
	 * @return Liste de tous les RH
	 */
	@GetMapping("")
	public Stream<Utilisateur> listRh() {
		System.out.println("RapportRestApi - listVisteur");
		Stream<Utilisateur> rhs = rhService.listRh();
		System.out.println("RhRestApi - listRh rhs=" + rhs);
		return rhs;
	}
	
	/**
	 * 
	 * @param id Id du RH recherché
	 * @return RH contenant l'id recherché
	 */
	@GetMapping("/{id}")
	public Rh getRh(@PathVariable("id") String id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return rhService.findRhById(id);
	}
	
	/**
	 * 
	 * @param holder Objet contenant le mot de passe et le RH que l'on souhaite créer
	 * @return RH créé
	 */
	@PostMapping("")
	public Rh createRh(@Valid @RequestBody HolderCreateUserRh holder) {
		System.out.println("VisiteurRestApi - create visiteur=" + holder);
		return rhService.createRh(holder.getRh(), holder.getPassword());
	}
	
	/**
	 * 
	 * @param id Id du RH à modifier
	 * @param rh Nouveau RH dans le RequestBody
	 * @return RH modifié
	 */
	@PutMapping("/{id}")
	public Rh updateRh(@PathVariable("id") String id, @Valid @RequestBody Rh rh) {
		return rhService.updateRhByid(id, rh);
	}
	
	/**
	 * 
	 * @param id Id du RH à supprimer
	 * @return RH supprimé
	 */
	@DeleteMapping("/{id}")
	public Rh deleteVisiteur(@PathVariable("id") String id) {
		return rhService.deleteRhById(id);
	}
	
	/**
	 * 
	 * @param date Date saisie par l'utilisateur
	 * @param type Type précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return Liste des RH embauchés avant ou après la date saisie
	 */
	@GetMapping(
			params = {"date", "type"}
	)
	public Stream<Utilisateur> listRhEmbaucheByDate(@RequestParam("date") String date, @RequestParam("type") String type) {
		return rhService.listRhByDateEmbauche(date, type);
	}
}
