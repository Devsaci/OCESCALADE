package org.ocescalade.dao;

import java.util.List;

import org.ocescalade.entities.Pret;
import org.ocescalade.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {

	/* Impl ProfilController methode List<Pret> lpe = pretRepository.####### */

	//List<Pret> findAllByEmprunteur(String userConnected);

	//List<Pret> findAllByProprietaire(String userConnected);

	//List<Pret> findPretsByProprietaireAndStatutIsNotAndStatutIsNot
	//(String username, String statut1, String statut2);

	//List<Pret> findPretsByEmprunteurAndStatutIsNotAndStatutIsNot
	//(String username, String statut1, String statut2);


	List<Pret> findAllByEmprunteur(String emprunteur);

	List<Pret> findAllByProprietaire(String proprietaire);

	//List<Pret> findPretsByProprietaireAndStatutIsNotAndStatutIsNot(User userConnected, String statut1, String statut2);


	//List<Pret> findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(User userConnected, String statut1, String statut2);

	List<Pret> findPretsByProprietaireAndStatutIsNotAndStatutIsNot(String proprietaire, String statut1, String statut2);

	List<Pret> findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(String emprunteur, String statut1, String statut2);

	List<Pret> findAllByEmprunteur(User userConnected);

	List<Pret> findAllByProprietaire(User userConnected);

	List<Pret> findPretsByProprietaireAndStatutIsNotAndStatutIsNot(User userConnected, String statut1, String statut2);

	List<Pret> findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(User userConnected, String statut1, String statut2);

}
