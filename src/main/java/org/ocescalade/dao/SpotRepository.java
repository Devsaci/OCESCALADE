package org.ocescalade.dao;

import org.ocescalade.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Integer> {

}
