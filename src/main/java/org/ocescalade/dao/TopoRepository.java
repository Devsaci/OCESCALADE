package org.ocescalade.dao;


import java.util.List;

import org.ocescalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Topo, Integer>{
		/* Impl  TopoController    */ 
	List<Topo> findByUser_IdIsNot(int id);

	Topo findToposByIdIs(Integer idt);
	
		/* Impl    ProfilController   */ 
	List<Topo> findTopoByUser_Username(String username);

	List<Topo> findToposByUser_Username(String username);

	Topo findTopoByNomTopo(String ndTopoPret);


	

}
