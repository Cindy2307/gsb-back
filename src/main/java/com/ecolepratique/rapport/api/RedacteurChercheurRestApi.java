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
import com.ecolepratique.rapport.entite.HolderCreateUserRedacteurChercheur;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.service.RedacteurChercheurServiceItf;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/redacteurchercheur")
@CrossOrigin("*")
public class RedacteurChercheurRestApi {
	@Autowired
	private RedacteurChercheurServiceItf redacteurChercheurService;

	/**
	 * 
	 * @return Liste des rédacteurs et des chercheurs
	 */
	@GetMapping("")
	public Stream<Utilisateur> listRedacteurChercheur() {
		System.out.println("RedacteurChercheurRestApi - listRedacteurChercheur");
		Stream<Utilisateur> redacteurChercheurs = redacteurChercheurService.listRedacteurChercheur();
		System.out.println(
				"RedacteurChercheurRestApi - listRedacteurChercheur redacteurChercheur=" + redacteurChercheurs);
		return redacteurChercheurs;
	}
	
	/**
	 * 
	 * @param id Id du rédacteur ou du chercheur concerné
	 * @return Rédacteur ou chercheur désiré
	 */
	@GetMapping("/{id}")
	public RedacteurChercheur getRedacteurChercheur(@PathVariable("id") String id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return redacteurChercheurService.findRedacteurChercheurById(id);
	}
	
	/**
	 * 
	 * @param holder Objet contenant le mot de passe et le rédacteur ou le chercheur que l'on souhaite créer
	 * @return Rédacteur ou chercheur créé
	 */
	@PostMapping("")
	public RedacteurChercheur createRedacteurChercheur(@Valid @RequestBody HolderCreateUserRedacteurChercheur holder) {
		System.out.println("RedacteurChercheurRestApi - create redacteurChercheur=" + holder);
		return redacteurChercheurService.createRedacteurChercheur(holder.getRedacteurChercheur(), holder.getPassword());
	}
	
	/**
	 * 
	 * @param id Id du rédacteur ou du chercheur que l'on souhaite modifier
	 * @param redacteurChercheur Nouveau rédacteur/chercheur dans le RequestBody
	 * @return Rédacteur/Chercheur modifié
	 */
	@PutMapping("/{id}")
	public RedacteurChercheur updateRedacteurChercheur(@PathVariable("id") String id,
			@Valid @RequestBody RedacteurChercheur redacteurChercheur) {
		return redacteurChercheurService.updateRedacteurChercheurByid(id, redacteurChercheur);
	}
	
	/**
	 * 
	 * @param id Id du rédacteur/Chercheur à supprimer
	 * @return Rédacteur/Chercheur supprimé
	 */
	@DeleteMapping("/{id}")
	public RedacteurChercheur deleteRedacteurChercheur(@PathVariable("id") String id) {
		return redacteurChercheurService.deleteRedacteurChercheurById(id);
	}
	
	/**
	 * 
	 * @param date Date entrée par l'utilisateur
	 * @param type Tupe précisant si la recherche doit être effectuée avant ou après la date saisie
	 * @return
	 */
	@GetMapping(
			params = {"date", "type"}
	)
	public Stream<Utilisateur> listRedacteurChercheurByDateEmbauche(@RequestParam("date") String date, @RequestParam("type") String type) {
		return redacteurChercheurService.listRedacteurChercheurByDateEmbauche(date, type);
	}
}
