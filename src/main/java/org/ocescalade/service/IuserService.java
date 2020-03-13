package org.ocescalade.service;

import org.ocescalade.entities.User;

public interface IuserService {
	public User connectedUser();

	public String connectedUsername();
}
