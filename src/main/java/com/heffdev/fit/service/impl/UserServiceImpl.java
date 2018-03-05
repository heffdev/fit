package com.heffdev.fit.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.heffdev.fit.domain.User;
import com.heffdev.fit.repository.HistoryRepository;
import com.heffdev.fit.repository.UserRepository;
import com.heffdev.fit.service.UserService;
import com.heffdev.fit.util.HeffDevConstants;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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
	private UserRepository userRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteUser(Long id) {
		historyRepository.deleteByDataIdAndTableName(id, User.tableName);
		userRepository.delete(id);

	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Iterable<User> listUsers() {
		return userRepository.findAll();
	}

}
