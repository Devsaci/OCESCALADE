package org.ocescalade.service;

import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User connectedUser() {
		String username = this.connectedUsername();	
		return this.userRepository.findUserByUsername(username);
	}

	public String connectedUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
