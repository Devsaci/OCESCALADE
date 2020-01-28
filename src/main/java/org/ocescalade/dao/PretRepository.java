package org.ocescalade.dao;

import java.util.List;

import org.ocescalade.entities.Pret;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PretRepository extends JpaRepository<Pret,Integer>{
/*  Impl ProfilController methode List<Pret> lpe = pretRepository.#######*/
	
	
	List<Pret> findAllByEmprunteur(String username);

	 List<Pret> findAllByProprietaire(String username);

	

	List<Pret> 
	findPretsByProprietaireAndStatutIsNotAndStatutIsNot
	(String username, String statut1, String statut2);

	List<Pret> 
	findPretsByEmprunteurAndStatutIsNotAndStatutIsNot
	(String username, String statut1, String statut2);

}
