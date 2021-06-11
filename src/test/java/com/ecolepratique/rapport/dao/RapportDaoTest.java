package com.ecolepratique.rapport.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.ecolepratique.rapport.entite.Rapport;

@ActiveProfiles("test")
@DataJpaTest
public class RapportDaoTest {

	@Autowired
	private RapportDaoItf repository;
	
	@Test
	public void testListRapportBymotifLike() {
		  List<Rapport> rapports = repository.findByMotifLike("%a%");
	      System.out.println("RapportDaoTest - testRapport liste = " + rapports);
	      assertEquals(5, rapports.size());
	}
}
