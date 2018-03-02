package com.heffdev.sns.repository;

import org.springframework.data.repository.CrudRepository;

import com.heffdev.sns.domain.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
