package com.heffdev.sns.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heffdev.sns.dto.CheckHealthResponse;
import com.heffdev.sns.exception.FitException;
import com.heffdev.sns.service.FitService;
import com.heffdev.sns.service.UserService;
import com.heffdev.sns.util.HeffDevConstants;
import com.heffdev.sns.util.ResponseCodes;

@RestController
public class FitController {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FitController.class);

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
	UserService userService;

	@Autowired
	FitService fitService;

	@RequestMapping(path = "${pathPattern:/fithealth}", method = POST, consumes = { "text/*", "application/json" })
	@ResponseStatus(HttpStatus.ACCEPTED)
	public CheckHealthResponse checkHealth(@RequestBody String body,
			@RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) {
		final StopWatch sw = new StopWatch();
		sw.start();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Starting health check");
		}
		CheckHealthResponse response = null;
		try {
			this.fitService.createHealthCheckPing();
			response = new CheckHealthResponse();
		} catch (final FitException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("An Exception was thrown while creating a new ExwDomain [" + e.getMessage() + "]", e);
			}
			response = new CheckHealthResponse(e.getCode());

		} catch (final Exception e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("An Unkown Exception was thrown while performing this action [" + e.getMessage() + "]", e);
			}
			response = new CheckHealthResponse(ResponseCodes.E9999);

		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Ending health check");
		}

		sw.stop();
		if (TIMELOG.isInfoEnabled()) {
			TIMELOG.info("Health check took [" + sw.getTime() + "] ms");
		}

		return response;

	}
}
