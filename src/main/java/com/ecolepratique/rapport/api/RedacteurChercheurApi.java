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
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.rapport.entite.HolderCreateUserRedacteurChercheur;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.service.RedacteurChercheurServiceItf;

@RestController
@RequestMapping("/redacteurchercheur")
@CrossOrigin("*")
public class RedacteurChercheurApi {
	@Autowired
	private RedacteurChercheurServiceItf RedacteurChercheurService;

	@GetMapping("")
	public Stream<Utilisateur> listRedacteurChercheur() {
		System.out.println("RedacteurChercheurRestApi - listRedacteurChercheur");
		Stream<Utilisateur> redacteurChercheurs = RedacteurChercheurService.listRedacteurChercheur();
		System.out.println(
				"RedacteurChercheurRestApi - listRedacteurChercheur redacteurChercheur=" + redacteurChercheurs);
		return redacteurChercheurs;
	}

	@GetMapping("/{id}")
	public RedacteurChercheur getRedacteurChercheur(@PathVariable("id") String id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return RedacteurChercheurService.findRedacteurChercheurById(id);
	}

	@PostMapping("")
	public RedacteurChercheur createRedacteurChercheur(@Valid @RequestBody HolderCreateUserRedacteurChercheur holder) {
		System.out.println("RedacteurChercheurRestApi - create redacteurChercheur=" + holder);
		return RedacteurChercheurService.createRedacteurChercheur(holder.getRedacteurChercheur(), holder.getPassword());
	}

	@PutMapping("/{id}")
	public RedacteurChercheur updateRedacteurChercheur(@PathVariable("id") String id,
			@Valid @RequestBody RedacteurChercheur redacteurChercheur) {
		return RedacteurChercheurService.updateRedacteurChercheurByid(id, redacteurChercheur);
	}

	@DeleteMapping("/{id}")
	public RedacteurChercheur deleteRedacteurChercheur(@PathVariable("id") String id) {
		return RedacteurChercheurService.deleteRedacteurChercheurById(id);
	}

}
