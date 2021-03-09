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
import com.ecolepratique.rapport.entite.HolderCreateUserRh;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.service.RhServiceItf;

@RestController
@RequestMapping("/rh")
@CrossOrigin("*")
public class RhApi {
	@Autowired
	private RhServiceItf rhService;

	@GetMapping("")
	public Stream<Utilisateur> listRh() {
		System.out.println("RapportRestApi - listVisteur");
		Stream<Utilisateur> rhs = rhService.listRh();
		System.out.println("RhRestApi - listRh rhs=" + rhs);
		return rhs;
	}

	@GetMapping("/{id}")
	public Rh getVisiteur(@PathVariable("id") String id) {
		System.out.println("VisiteurRestApi - get(id) ");
		return rhService.findRhById(id);
	}

	@PostMapping("")
	public Rh createRh(@Valid @RequestBody HolderCreateUserRh holder) {
		System.out.println("VisiteurRestApi - create visiteur=" + holder);
		return rhService.createRh(holder.getRh(), holder.getPassword());
	}

	@PutMapping("/{id}")
	public Rh updateRh(@PathVariable("id") String id, @Valid @RequestBody Rh rh) {
		return rhService.updateRhByid(id, rh);
	}

	@DeleteMapping("/{id}")
	public Rh deleteVisiteur(@PathVariable("id") String id) {
		return rhService.deleteRhById(id);
	}
}
