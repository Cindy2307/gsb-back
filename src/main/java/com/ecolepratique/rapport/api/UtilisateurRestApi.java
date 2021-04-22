package com.ecolepratique.rapport.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.rapport.service.UtilisateurServiceItf;

/**
 * 
 * @author Utilisateur
 *
 */
@RestController
@RequestMapping("/pourcentageUtilisateurs")
@CrossOrigin("*")
public class UtilisateurRestApi {
	
	@Autowired
	private UtilisateurServiceItf utilisateurService;
	
	@GetMapping("")
	public List<Double> getPourcentage(){
		return utilisateurService.pourcentageTypesUtilisateurs();
	}
}
