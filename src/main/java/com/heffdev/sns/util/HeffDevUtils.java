package com.heffdev.sns.util;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeffDevUtils {

	/**
	 * A logging <code>Logger</code> for writing log entries for the Class level
	 * logs.
	 */
	private static final Logger log = LoggerFactory.getLogger(HeffDevUtils.class);
	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * execution time logs.
	 */
	private static Logger log_time = LoggerFactory.getLogger(HeffDevConstants.TIME_LOGGER);

	/**
	 * A logging <code>Logger</code> for writing log entries for the system
	 * boundary logs.
	 */
	private static Logger log_sys_bndry = LoggerFactory.getLogger(HeffDevConstants.SYS_BOUNDARY_LOGGER);

	public static <T> Set<T> toHashSet(final Iterable<T> iterable) {
		if (iterable == null) {
			return new HashSet<>();
		}
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toSet());
	}

	public static String toStringOfNumbers(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int v = Character.getNumericValue(s.charAt(i));
			sb.append(v < 0 ? v * -1 : v);
		}
		if (log.isDebugEnabled()) {
			log.debug("Will return [" + sb.toString() + "]");
		}
		return sb.toString();
	}

}
