package org.ocescalade.dao;




import org.ocescalade.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	

	

	

	User findUserByUsername(String username);


	//User findUserById(String username);


	



}
