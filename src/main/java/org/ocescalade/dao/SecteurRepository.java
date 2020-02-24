package org.ocescalade.dao;

import java.util.List;

import org.ocescalade.entities.Secteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

	 @Query ("SELECT e FROM Secteur e WHERE e.nomSecteur LIKE :x" )
     List<Secteur> chercheSecteur(@Param("x")String nom);
	 
	//implement spotControlleur method 
	List<Secteur> findSecteursBySpotId(Integer sid);
	



}
