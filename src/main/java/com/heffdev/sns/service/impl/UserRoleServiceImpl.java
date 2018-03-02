package com.heffdev.sns.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heffdev.sns.domain.UserRole;
import com.heffdev.sns.repository.HistoryRepository;
import com.heffdev.sns.repository.UserRoleRepository;
import com.heffdev.sns.service.UserRoleService;
import com.heffdev.sns.util.HeffDevConstants;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * execution time logs.
	 */
	private static Logger TIMELOG = LoggerFactory.getLogger(HeffDevConstants.TIME_LOGGER);

	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * boundary logs.
	 */
	private static Logger LOGSYSBNDRY = LoggerFactory.getLogger(HeffDevConstants.SYS_BOUNDARY_LOGGER);

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteUserRole(Long id) {
		historyRepository.deleteByDataIdAndTableName(id, UserRole.tableName);
		userRoleRepository.delete(id);

	}

	@Override
	public UserRole findUserRoleById(Long id) {
		return userRoleRepository.findOne(id);
	}

	@Override
	public UserRole getUserRoleById(Long id) {
		return userRoleRepository.findOne(id);
	}

	@Override
	public Iterable<UserRole> listUserRoles() {
		return userRoleRepository.findAll();
	}

}
