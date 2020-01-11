package org.ocescalade.dao;

import java.util.List;

import org.ocescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SpotRepository extends JpaRepository<Spot, Integer> {

	@Query ("SELECT s FROM Spot s WHERE s.nomSpot LIKE :x")
	List<Spot> chercherSpot(@Param("x")String mc);
	
	List<Spot> fingByNomSiteAndDescriptionSite(String mc1,String mc2);
	
	@Override
    Spot getOne(Integer integer);
			 
	
	
}
