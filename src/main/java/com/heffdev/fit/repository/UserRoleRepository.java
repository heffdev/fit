package com.heffdev.fit.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.fit.domain.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
