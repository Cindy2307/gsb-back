package com.ecolepratique.rapport;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ecolepratique.rapport.dao.OffreEchantillonDaoItf;
import com.ecolepratique.rapport.dao.RapportDaoItf;
import com.ecolepratique.rapport.dao.RedacteurChercheurDaoItf;
import com.ecolepratique.rapport.dao.RhDaoItf;
import com.ecolepratique.rapport.dao.UserDaoItf;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;
import com.ecolepratique.rapport.entite.Medicament;
import com.ecolepratique.rapport.entite.OffreEchantillon;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.MedicamentServiceItf;
import com.ecolepratique.rapport.service.RapportServiceItf;
import com.ecolepratique.rapport.service.RhServiceItf;

@SpringBootApplication
public class RapportVisiteBdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RapportVisiteBdApplication.class, args);
		RapportDaoItf  rapportDao = ctx.getBean(RapportDaoItf.class);
		VisiteurDaoItf visiteurDao = ctx.getBean(VisiteurDaoItf.class);
		MedicamentServiceItf medicamentService = ctx.getBean(MedicamentServiceItf.class);
		UserRoleDaoItf utilisateurRoleDao = ctx.getBean(UserRoleDaoItf.class);
		UserDaoItf userDao = ctx.getBean(UserDaoItf.class);
		RedacteurChercheurDaoItf redacteurChercheurDao = ctx.getBean(RedacteurChercheurDaoItf.class);
		RhDaoItf rhDao = ctx.getBean(RhDaoItf.class);
		RhServiceItf rhService = ctx.getBean(RhServiceItf.class);
		OffreEchantillonDaoItf offreDao = ctx.getBean(OffreEchantillonDaoItf.class);
		
		Visiteur visiteur1 = new Visiteur("Coco", "ollive", "cindy", "108 bd de la valbarelle BT D5", 13011, "Marseille", LocalDate.of(1995, 07, 23));
		User user1 = new User("Coco", "Coucou_13");
		utilisateurRoleDao.save(new UserRole("Coco","VIS"));
		visiteurDao.save(visiteur1);
		userDao.save(user1);
		Rapport rapport1 = new Rapport(LocalDate.of(2018, 1, 14), "J'ai présenté le médicament HELICIDINE au généraliste, Monsieur Baturin, qui a une action sédative sur la toux. "
				+ "Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru être trés interessé. Je lui ai laissé 4 échantillons afin qu'il puisse le tester"
				+ " J'ai été agréablement de son retour et espére qu'il sera un contact moteur pour l'avenir. Cette visite est une totale réussite."
				, "Ce praticien n'a pas encore été visité");
		System.out.println("Taille chaine=" + rapport1.getBilan().length());
		Rapport rapport2 = new Rapport(LocalDate.of(2020, 10, 22), "J'ai présenté notre nouveau médicament, HELICIDINE, au pneumologue, Monsieur Raphaelle, qui a une action sédative sur la toux. \"\n" + 
				"				+ \"Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru septique. Je lui ai laissé 6 échantillons afin qu'il puisse le tester et lui prouvé l'efficacité de ce médicament\"\n" + 
				"				+ \" Son retour n'a pas été bon, je lui ai dit que je le recontacterais dans 3 mois, le temps qu'il teste le médicament et qu'il puisse faire un prmeier retour. Cette visite a été délicate.\"\n" + 
				"				, \"Ce praticien n'a pas encore été visité", "Ce praticien ne connaissait pas notre nouveau médicament, l'HELICIDINE");
		rapportDao.save(rapport1);
		rapportDao.save(rapport2);
		visiteur1.addRapport(rapport1);
		visiteur1.addRapport(rapport2);
		visiteurDao.save(visiteur1);
		
		Visiteur visiteur2 = new Visiteur("Coco2", "ollive2", "cindy2", "108 bd de la valbarelle BT D4", 13012, "Marseille", LocalDate.of(1995, 07, 25));
		User user2 = new User("Coco2", "Coucou2_13");
		utilisateurRoleDao.save(new UserRole("Coco2","VIS"));
		visiteurDao.save(visiteur2);
		userDao.save(user2);
		rapport1 = new Rapport(LocalDate.of(2016, 04, 10), "J'ai présenté notre médicament SPEDIFEN, au généraliste Monsieur Touffart. Ce médicament est un anti-inflammatoire non stéroïdien (AINS). Il lutte contre la douleur et fait baisser la fièvre. Ses propriétés anti-inflammatoires se manifestent à forte dose.\n" + 
				"\n" + 
				"Il est utilisé dans le traitement de courte durée de la fièvre et de la douleur (maux de tête, douleurs dentaires, courbatures, règles douloureuses...). Monsieur Touffart a semblé être trés intéressé par les résultats des études que je lui ai présenté. Je lui ai laissé 2 échantillons.", "Quand j'ai contacté ce praticien, il était demandeur d'une rencontre.");
		rapport2 = new Rapport(LocalDate.of(2018, 01, 12), "J'ai présenté notre nouveau médicament l'IXPRIM, à l'infirmiére Madame Bichard qui officie à l'hôpital conception. Traitement symptomatique des douleurs modérées à intenses.\n" + 
				"L'utilisation d'Ixprim doit être limitée aux patients dont la douleur modérée à intense nécessite un traitement par une association de paracétamol et de tramadol. Madame Bichard avait trés peu de temps et à l'air débordée en cette période. en fin d'entretin je lui ai promis de revenir la voir quand elle aura plus de disponibilité.", "Premiére rencontre de cette praticienne. Permet d'établir un contact");
		Rapport rapport3 = new Rapport(LocalDate.of(2014, 01, 14), "J'ai rencontré le docteur Mabuse qui est cardilogue à l'hôpital bichat pour lui présenter notre médicament le DAFLON. Ce médicament est un veinotonique et un protecteur vasculaire. Il stimule la circulation du sang dans les veines et lutte contre l'altération des vaisseaux capillaires. Le praticien a semblé trés "
				+ "intéressé par les études d'impact que je lui ai présenté. Il avait des questions trés précise et semble être trés compétent dans son domaine",
				"Praticien qui a une grande influence dans le milieur de la cardiologie");
		rapportDao.save(rapport1);
		rapportDao.save(rapport2);
		rapportDao.save(rapport3);
		visiteur2.addRapport(rapport1);
		visiteur2.addRapport(rapport2);
		visiteur2.addRapport(rapport3);
		visiteurDao.save(visiteur2);
		
		RedacteurChercheur redacteur1 = new RedacteurChercheur("Coco3", "ollive3", "cindy3", "108 bd de la valbarelle BT D2", 13013, "Marseille", LocalDate.of(1995, 07, 27));
		User user3 = new User("Coco3", "Coucou3_13");
		utilisateurRoleDao.save(new UserRole("Coco3","RC"));
		redacteurChercheurDao.save(redacteur1);
		userDao.save(user3);
		
		Rh rh1 = new Rh("Coco4", "ollive4", "cindy4", "108 bd de la valbarelle BT D1", 13014, "Marseille", LocalDate.of(1995, 07, 31));
		User user4 = new User("Coco4", "Coucou4_13");
		utilisateurRoleDao.save(new UserRole("Coco4","RH"));
		rhDao.save(rh1);
		userDao.save(user4);
		
		Rh rh2 = new Rh("Coco5", "ollive5", "cindy5", "108 bd de la valbarelle BT D2", 13010, "Marseille", LocalDate.of(1995, 07, 3));
		User user5 = new User("Coco5", "Coucou5_13");
		utilisateurRoleDao.save(new UserRole("Coco5","RH"));
		rhDao.save(rh2);
		userDao.save(user5);
		
		Visiteur visiteur3 = new Visiteur("Benji", "Benjamin", "desMarseillais", "108 bd de la valbarelle BT D5", 13011, "Marseille", LocalDate.of(1995, 07, 23));
		User user6 = new User("Benji", "Coucou6_13");
		utilisateurRoleDao.save(new UserRole("Benji","VIS"));
		visiteurDao.save(visiteur3);
		userDao.save(user6);
		
		Medicament medicament1 = new Medicament("LEVOTHYROX"); 
		Medicament medicament2 = new Medicament("TAHOR"); 
		Medicament medicament3 = new Medicament("HELICIDINE"); 
		Medicament medicament4 = new Medicament("ANTARENE"); 
		Medicament medicament5 = new Medicament("IMODIUM"); 
		Medicament medicament6 = new Medicament("ISIMIG"); 
		Medicament medicament7 = new Medicament("SPEDIFEN"); 
		Medicament medicament8 = new Medicament("IXPRIM"); 
		Medicament medicament9 = new Medicament("FORLAX"); 
		Medicament medicament10 = new Medicament("LAMALINE"); 
		Medicament medicament11 = new Medicament("DAFLON"); 
		Medicament medicament12 = new Medicament("CELESTENE"); 
		
		medicament12.addEffet("Hypokaliémie");
		medicament12.addEffet("Alcalose métabolique");
		medicament12.addEffet("Rétention hydrosodée");
		medicament12.addEffet("Hypertension artérielle");
		medicament12.addContreIndication("Herpès");
		medicament12.addContreIndication("Varicelle");
		medicament12.addContreIndication("Zona");
		medicament12.addContreIndication("Etat psychotique non contrôlé");
		
		medicament11.addEffet("Céphalée");
		medicament11.addEffet("Malaise");
		medicament11.addEffet("Diarrhée");
		medicament11.addEffet("Dyspepsie");
		medicament11.addContreIndication("Hypersensibilité flavonoïdes");
		medicament11.addContreIndication("Hypersensibilité diosmine");
		medicament11.addContreIndication("Hypersensibilité hespéridine");
		
		medicament10.addEffet("Choc anaphylactique");
		medicament10.addEffet("Oedème de Quincke");
		medicament10.addEffet("Erythème cutané");
		medicament10.addEffet("Urticaire allergique");
		medicament10.addContreIndication("Asthme");
		medicament10.addContreIndication("Grossesse");
		medicament10.addContreIndication("Allaitement");
		
		medicament9.addEffet("Diarrhée");
		medicament9.addEffet("Nausée");
		medicament9.addEffet("Vomissement");
		medicament9.addContreIndication("Hypersensibilité macrogol");
		medicament9.addContreIndication("Maladie de Crohn");
		medicament9.addContreIndication("Perforation digestive");
		
		medicament8.addEffet("Palpitation");
		medicament8.addEffet("Tachycardie");
		medicament8.addEffet("Arythmie");
		medicament8.addContreIndication("Hypersensibilité tramadol");
		medicament8.addContreIndication("Epilepsie non contrôlée");
		medicament8.addContreIndication("Grossesse");
		
		
		medicament7.addEffet("Thrombopénie");
		medicament7.addEffet("Agranulocytose");
		medicament7.addEffet("Anémie aplasique");
		medicament7.addEffet("Anémie");
		medicament7.addContreIndication("Hémorragie gastro-intestinale");
		medicament7.addContreIndication("Hémorragie cérébrovasculaire");
		medicament7.addContreIndication("Diathèse hémorragique");
		
		
		medicament5.addEffet("Céphalée");
		medicament5.addEffet("Sensation vertigineuse");
		medicament5.addEffet("Somnolence");
		medicament5.addEffet("Perte de conscience");
		medicament5.addContreIndication("Hypersensibilité lopéramide");
		medicament5.addContreIndication("Colite pseudomembraneuse");
		medicament5.addContreIndication("Intolérance au galactose");
		medicament5.addContreIndication("Déficit en lactase");
		
		medicament6.addEffet("Angioedème");
		medicament6.addEffet("Anaphylaxie");
		medicament6.addEffet("Déshydratation");
		medicament6.addEffet("Hypoglycémie");
		medicament6.addContreIndication("Pathologie cardiaque ischémique");
		medicament6.addContreIndication("Vasospasme coronarien");
		medicament6.addContreIndication("Pathologie vasculaire périphérique");
		
		medicament1.addEffet("Nausées");
		medicament1.addEffet("Maux de tête");
		medicament1.addEffet("Démangeaisons");
		medicament1.addContreIndication("Gentamicine");
		medicament1.addContreIndication("Halofantrine");
		
		medicament2.addEffet("Somnolence");
		medicament2.addEffet("Diarrhée");
		medicament2.addContreIndication("Lincomycine");
		medicament2.addContreIndication("Pindolol");
		
		medicament3.addEffet("Vision floue");
		medicament3.addEffet("Fatigue");
		medicament3.addContreIndication("Propafénone");
		medicament3.addContreIndication("Quinine");
		
		medicament4.addEffet("Somnolence");
		medicament4.addEffet("Vision floue");
		medicament4.addEffet("Eruption cutanée");
		medicament4.addContreIndication("Halofantrine");
		medicament4.addContreIndication("Pindolol");
		medicament4.addContreIndication("Quinine");
		
		medicamentService.create(medicament1);
		medicamentService.create(medicament2);
		medicamentService.create(medicament3);
		medicamentService.create(medicament4);
		medicamentService.create(medicament5);
		medicamentService.create(medicament6);
		medicamentService.create(medicament7);
		medicamentService.create(medicament8);
		medicamentService.create(medicament9);
		medicamentService.create(medicament10);
		medicamentService.create(medicament11);
		medicamentService.create(medicament12);
		
		OffreEchantillon offre1 = new OffreEchantillon(10, medicament7);
		OffreEchantillon offre2 = new OffreEchantillon(5, medicament7);
		offreDao.save(offre1);
		offreDao.save(offre2);
		rapport2.addOffre(offre1);
		rapport2.addOffre(offre2);
		
		rapportDao.save(rapport2);
		
		System.out.println(rhService.numberOfRh());
	}
}


