package com.ecolepratique.rapport;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ecolepratique.rapport.dao.RapportDaoItf;
import com.ecolepratique.rapport.dao.RedacteurChercheurDaoItf;
import com.ecolepratique.rapport.dao.RhDaoItf;
import com.ecolepratique.rapport.dao.UserDaoItf;
import com.ecolepratique.rapport.dao.UserRoleDaoItf;
import com.ecolepratique.rapport.dao.VisiteurDaoItf;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.RedacteurChercheur;
import com.ecolepratique.rapport.entite.Rh;
import com.ecolepratique.rapport.entite.User;
import com.ecolepratique.rapport.entite.UserRole;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.RapportServiceItf;
import com.ecolepratique.rapport.service.RhServiceItf;
import com.ecolepratique.rapport.service.UtilisateurServiceItf;

@SpringBootApplication
public class RapportVisiteBdApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RapportVisiteBdApplication.class, args);
		RapportDaoItf  rapportDao = ctx.getBean(RapportDaoItf.class);
		VisiteurDaoItf visiteurDao = ctx.getBean(VisiteurDaoItf.class);
		UserRoleDaoItf utilisateurRoleDao = ctx.getBean(UserRoleDaoItf.class);
		UserDaoItf userDao = ctx.getBean(UserDaoItf.class);
		RedacteurChercheurDaoItf redacteurChercheurDao = ctx.getBean(RedacteurChercheurDaoItf.class);
		RhDaoItf rhDao = ctx.getBean(RhDaoItf.class);
		
		Visiteur visiteur1 = new Visiteur("Coco", "ollive", "cindy", "108 bd de la valbarelle BT D5", 13011, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 23));
		User user1 = new User("Coco", "Coucou_13");
		utilisateurRoleDao.save(new UserRole("Coco","VIS"));
		visiteurDao.save(visiteur1);
		userDao.save(user1);
		Rapport rapport1 = new Rapport(LocalDate.of(2018, 1, 14), "J'ai présenté le médicament HELICIDINE au généraliste, Monsieur Baturin, qui a une action sédative sur la toux. "
				+ "Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru être trés interessé. Je lui ai laissé 4 échantillons afin qu'il puisse le tester"
				+ " J'ai été agréablement de son retour et espére qu'il sera un contact moteur pour l'avenir. Cette visite est une totale réussite."
				, "Ce praticien n'a pas encore été visité");
		Rapport rapport2 = new Rapport(LocalDate.of(2020, 10, 22), "J'ai présenté notre nouveau médicament, HELICIDINE, au pneumologue, Monsieur Raphaelle, qui a une action sédative sur la toux. \"\n" + 
				"				+ \"Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru septique. Je lui ai laissé 6 échantillons afin qu'il puisse le tester et lui prouvé l'efficacité de ce médicament\"\n" + 
				"				+ \" Son retour n'a pas été bon, je lui ai dit que je le recontacterais dans 3 mois, le temps qu'il teste le médicament et qu'il puisse faire un prmeier retour. Cette visite a été délicate.\"\n" + 
				"				, \"Ce praticien n'a pas encore été visité", "Ce praticien ne connaissait pas notre nouveau médicament, l'HELICIDINE");
		rapportDao.save(rapport1);
		rapportDao.save(rapport2);
		visiteur1.addRapport(rapport1);
		visiteur1.addRapport(rapport2);
		visiteurDao.save(visiteur1);
		
		Visiteur visiteur2 = new Visiteur("Coco2", "ollive2", "cindy2", "108 bd de la valbarelle BT D4", 13012, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 25));
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
		
		RedacteurChercheur redacteur1 = new RedacteurChercheur("Coco3", "ollive3", "cindy3", "108 bd de la valbarelle BT D2", 13013, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 27));
		User user3 = new User("Coco3", "Coucou3_13");
		utilisateurRoleDao.save(new UserRole("Coco3","RC"));
		redacteurChercheurDao.save(redacteur1);
		userDao.save(user3);
		
		Rh rh1 = new Rh("Coco4", "ollive4", "cindy4", "108 bd de la valbarelle BT D1", 13014, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 31));
		User user4 = new User("Coco4", "Coucou4_13");
		utilisateurRoleDao.save(new UserRole("Coco4","RH"));
		rhDao.save(rh1);
		userDao.save(user4);
		
		Rh rh2 = new Rh("Coco5", "ollive5", "cindy5", "108 bd de la valbarelle BT D2", 13010, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 3));
		User user5 = new User("Coco5", "Coucou5_13");
		utilisateurRoleDao.save(new UserRole("Coco5","RH"));
		rhDao.save(rh2);
		userDao.save(user5);
		
		Visiteur visiteur3 = new Visiteur("Benji", "Benjamin", "desMarseillais", "108 bd de la valbarelle BT D5", 13011, "Marseille", LocalDate.of(2021, 04, 20), LocalDate.of(1995, 07, 23));
		User user6 = new User("Benji", "Coucou6_13");
		utilisateurRoleDao.save(new UserRole("Benji","VIS"));
		visiteurDao.save(visiteur3);
		userDao.save(user6);
		
		rapportDao.save(rapport2);
	}
}


