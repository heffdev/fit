package com.heffdev.sns.service;

import com.heffdev.sns.domain.User;

public interface UserService {

	void deleteUser(Long id);

	User findUserById(Long id);

	User getUserById(Long id);

	Iterable<User> listUsers();

}