package com.heffdev.sns.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.heffdev.sns.domain.User;
import com.heffdev.sns.domain.UserRole;
import com.heffdev.sns.repository.HistoryRepository;
import com.heffdev.sns.repository.UserRepository;
import com.heffdev.sns.repository.UserRoleRepository;
import com.heffdev.sns.util.HeffDevConstants;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

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

	private static boolean hasRun = false;

	@Value("${com.heffdev.kfm.development:true}")
	private String isDev;

	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private HistoryRepository historyRepository;

	private void defaultUsers() {
		LOGGER.info("Creating default Users");

		User admin = new User();
		admin.setEnabled(true);
		admin.setPassword("admin");
		admin.setUsername("admin");
		admin.setEmail("admin@heffdev.com");
		admin = this.userRepository.save(admin);

		final UserRole ur = new UserRole();
		ur.setRole("ROLE_ADMIN");
		ur.setUsername(admin);
		this.userRoleRepository.save(ur);

		final UserRole ur2 = new UserRole();
		ur2.setRole("ROLE_USER");
		ur2.setUsername(admin);
		this.userRoleRepository.save(ur2);

		LOGGER.info("Saved Admin - id: " + admin.getUsername());

		User user = new User();
		user.setEnabled(true);
		user.setPassword("user");
		user.setUsername("user");
		user.setEmail("user@heffdev.com");
		user = this.userRepository.save(user);

		final UserRole ur3 = new UserRole();
		ur3.setRole("ROLE_USER");
		ur3.setUsername(user);
		this.userRoleRepository.save(ur3);

		LOGGER.info("Saved User - id: " + user.getUsername());
	}

	private boolean loadAllData() {
		try {
			this.userRoleRepository.deleteAll();
			this.historyRepository.deleteAll();
			this.userRepository.deleteAll();

			this.defaultUsers();
			this.loadAllUsers();

		} catch (final Exception e) {
			LOGGER.error("Error loading product data", e);
			return false;
		}
		return true;
	}

	private void loadAllUsers() {

		for (int i = 0; i < 100; i++) {

			User user = new User();
			user.setEnabled(true);
			user.setPassword("password " + i);
			user.setUsername("username " + i);
			user.setEmail("email " + i);

			user = this.userRepository.save(user);

			final UserRole ur3 = new UserRole();
			ur3.setRole("ROLE_USER");
			ur3.setUsername(user);
			this.userRoleRepository.save(ur3);
			LOGGER.info("Saved User - id: " + user.getUsername());
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Will now create new User data");
		}

	}

	private void loadData() {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In DEV mode, will proceed to load test data:");
		}
		this.loadAllData();

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (LOGGER.isWarnEnabled()) {
			LOGGER.warn("--- Bootstrap Dataloading is turned off in DEV MODE!! ---");
		}
		if (Boolean.valueOf(this.isDev).equals(Boolean.TRUE)) {
			if (!hasRun) {
				// loadData();
			} else {
				LOGGER.debug("Test data already loaded");
			}
		} else {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("DEV mode is FALSE. No test data will be produced");
			}
		}
		if (LOGGER.isWarnEnabled()) {
			LOGGER.warn("--- Bootstrap Dataloading is turned off in DEV MODE!! ---");
		}

		hasRun = true;

	}

	@Autowired
	public void setProductRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
