package com.ecolepratique.rapport.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Rapport;

/**
 * 
 * @author Christophe
 *
 */
public interface RapportDaoItf extends JpaRepository<Rapport, Long> {
	/**
	 * 
	 * @param motcle Ex: nom de medicament
	 * @return Liste de rapports contenant le mot clé dans le bilan
	 */
	List<Rapport> findByBilanLike(String motcle);
	
	/**
	 * 
	 * @param motcle Ex: nom de medicament
	 * @return Liste de rapports contenant le mot clé dans le motif
	 */
	List<Rapport> findByMotifLike(String motcle);
	
	/**
	 * 
	 * @param date Date du rapport
	 * @return Liste de tous les rapports datés apres la date saisie
	 */
	List<Rapport> findByDateAfter(LocalDate date);
	
	/**
	 * 
	 * @param date Date du rapport
	 * @return Liste de tous les rapports datés avant la date saisie
	 */
	List<Rapport> findByDateBefore(LocalDate date);
}
