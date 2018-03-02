package com.heffdev.sns.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.sns.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
