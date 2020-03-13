package org.ocescalade.service;

import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IuserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User connectedUser() {
		String username = this.connectedUsername();
		return this.userRepository.findUserByUsername(username);
	}

	
	@Override
	public String connectedUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
