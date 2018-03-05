package com.heffdev.fit.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.fit.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
