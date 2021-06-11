package com.ecolepratique.rapport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.service.RapportServiceItf;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceJpaIntegrationTest {

	@Autowired
	private RapportServiceItf rapportService;
	
	@WithMockUser(username = "Coco3", password = "Coucou3_13", authorities = "ROLE_RC")
	@Test
	public void testAllOffre(){
		List<Rapport> offres = rapportService.listRapport();
		System.out.println("ServiceJpaIntegrationTest - testAllOffre offres=" + offres);
		assertEquals(5, offres.size());
	}
}
