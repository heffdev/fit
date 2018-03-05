package com.heffdev.fit.service;

import com.heffdev.fit.domain.User;

public interface UserService {

	void deleteUser(Long id);

	User findUserById(Long id);

	User getUserById(Long id);

	Iterable<User> listUsers();

}