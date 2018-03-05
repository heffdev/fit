package com.heffdev.fit.service.impl;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.heffdev.fit.exception.FitException;
import com.heffdev.fit.service.FitService;
import com.heffdev.fit.util.HeffDevConstants;
import com.heffdev.fit.util.ResponseCodes;

@Service
public class FitServiceImpl implements FitService {
	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FitServiceImpl.class);

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

	/* (non-Javadoc)
	 * @see com.heffdev.sns.service.impl.FitService#createHealthCheckPing()
	 */
	@Override
	public void createHealthCheckPing() throws FitException {
		final StopWatch sw = new StopWatch();
		sw.start();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Start createHealthCheckPing()");
		}
		try {

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Health is OK");
			}

		} catch (final Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				if (LOGGER.isErrorEnabled()) {
					LOGGER.error(
							"Unable to create the HealthCheckPing with details. Likely cause is that a foriegn key, unique key, primary key, or mandatory field violation occurred. Check data for integrity ");
				}
				throw new FitException(ResponseCodes.E9002, e);
			} else {
				// Unkown Exception
				if (LOGGER.isErrorEnabled()) {
					LOGGER.error("Unkown Exception while attempting to create the HealthCheckPing.");
				}
				throw new FitException(ResponseCodes.E9999, e);
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("End createHealthCheckPing()");
		}
		sw.stop();
		if (TIMELOG.isInfoEnabled()) {
			TIMELOG.info("createHealthCheckPing() took [" + sw.getTime() + "] ms");
		}
	}

}
