package com.heffdev.sns.util;

import java.math.BigDecimal;

public class HeffDevConstants {

	/**
	 * This is the key which will be mapped to a logger in the log4j
	 * configuration and used within the application to output logging
	 * information where we call external systems
	 */
	public static final String SYS_BOUNDARY_LOGGER = "SysBoundaryLogger";

	/**
	 * This is the key which will be mapped to a logger in the log4j
	 * configuration and used within the application to output logging
	 * information where we call external systems
	 */
	public static final String TIME_LOGGER = "TimeLogger";

	public final static BigDecimal RULEOF72 = new BigDecimal(72.73);

	public final static BigDecimal POINTSPAID = new BigDecimal(100);

	public final static BigDecimal TWELVE = new BigDecimal(12);

	public final static BigDecimal TWO = new BigDecimal(2);

}
