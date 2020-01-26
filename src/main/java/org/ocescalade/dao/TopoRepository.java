package org.ocescalade.dao;


import java.util.List;

import org.ocescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Topo, Integer>{

	List<Topo> findAllByNomProprietaireIsNot(String username);

	Topo findToposByIdTopoIs(Integer idt);

}
