package org.ocescalade.dao;


import java.util.List;

import org.ocescalade.entities.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoieRepository extends JpaRepository<Voie, Integer> {

	
	@Query ("SELECT e FROM Voie e WHERE e.nomVoie LIKE :x" )
    List<Voie> chercheVoie(@Param("x")String nom);
	List<Voie> findVoiesBySecteurSpotIdSpot(Integer sid);

}
