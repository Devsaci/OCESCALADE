package org.ocescalade.dao;

import java.util.List;

import org.ocescalade.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer>{

	List<Commentaire> findCommentairesBySpotId(Integer sid);


}
