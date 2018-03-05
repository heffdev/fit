package com.heffdev.fit.service;

import com.heffdev.fit.domain.UserRole;

public interface UserRoleService {

	void deleteUserRole(Long id);

	UserRole findUserRoleById(Long id);

	UserRole getUserRoleById(Long id);

	Iterable<UserRole> listUserRoles();

}