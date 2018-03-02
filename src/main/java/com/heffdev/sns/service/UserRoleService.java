package com.heffdev.sns.service;

import com.heffdev.sns.domain.UserRole;

public interface UserRoleService {

	void deleteUserRole(Long id);

	UserRole findUserRoleById(Long id);

	UserRole getUserRoleById(Long id);

	Iterable<UserRole> listUserRoles();

}