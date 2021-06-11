package com.ecolepratique.rapport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ecolepratique.rapport.dao.RedacteurChercheurDaoItf;
import com.ecolepratique.rapport.dao.RhDaoItf;
import com.ecolepratique.rapport.dao.UtilisateurDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.Utilisateur;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.UtilisateurService;

@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTest {
	@InjectMocks
	private UtilisateurService utilisateurService;
	
	@Mock
	private UtilisateurDaoItf utilisateurDaoMock;
	
	@Mock
	private VisiteurDaoItf visiteurDaoMock;
	
	@Mock
	private RhDaoItf rhDaoMock;
	
	@Mock
	private RedacteurChercheurDaoItf rcDaoMock;
	
	@Test
	public void pourcentageTypesUtilisateursTest() {
		List<Double> result = Arrays.asList(40.0, 30.0, 30.0);
		List<Utilisateur> utilisateurs = Arrays.asList(new Visiteur(), new Visiteur(), new Visiteur(), new Visiteur(), new Rh(), new Rh(), new Rh(), new RedacteurChercheur(), new RedacteurChercheur(), new RedacteurChercheur());
		List<Utilisateur> visiteurs = Arrays.asList(new Visiteur(), new Visiteur(), new Visiteur(), new Visiteur());
		List<Utilisateur> rhs = Arrays.asList(new Rh(), new Rh(), new Rh());
		List<Utilisateur> rcs = Arrays.asList(new RedacteurChercheur(), new RedacteurChercheur(), new RedacteurChercheur());
		
		// GIVEN
		when(utilisateurDaoMock.findAll()).thenReturn(utilisateurs);
		when(visiteurDaoMock.findAll()).thenReturn(visiteurs);
		when(rhDaoMock.findAll()).thenReturn(rhs);
		when(rcDaoMock.findAll()).thenReturn(rcs);
		
		// WHEN
		List<Double> pourcentages = utilisateurService.pourcentageTypesUtilisateurs();
		
		// THEN
		assertEquals(result, pourcentages);
	}
	
}