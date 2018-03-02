package com.heffdev.sns.util;

public enum ResponseCodes {

	/**
	 * Everything OK
	 */
	OK("0000", "Request has been processed"),
	/**
	 * Unknown error
	 */
	E9000("E9000", "Unknown Error"),
	/**
	 * Associated Entity is not found in the database
	 */
	E9001("E9001", "The entity associated with this entity, via a foreign key, is not present in the database. Check your configuration again"),
	/**
	 * SQL Integrity Constraint Violation Exception
	 */
	E9002("E9002", "Unable to persist the data as it was submitted due to an SQL Integrity Constraint Violation Exception. Check data to ensure mandatory fields are present, unique fields are unique and references to associated data are correct"),
	/**
	 * Unable to locate the Object specified by the provided primary key. Check
	 * that the primary key specified is correct
	 */
	E9003("E9003", "Unable to locate the Object specified by the provided primary key. Check that the primary key specified is correct"),
	/**
	 * Invalid or missing parameters
	 */
	E9004("E9004", "Invalid or missing parameters"),
	/**
	 * Both BEGIN and END dates must be specified
	 */
	E9007("E9007", "Both BEGIN and END dates must be specified"),
	/**
	 * BEGIN date must be after END date
	 */
	E9008("E9008", "BEGIN date must be after END date"),
	/**
	 * BEGIN date must be after END date
	 */

	/**
	 * Unkown Exception occurred. Please check log files for the cause or
	 * contact your Administrator
	 */
	E9999("E9999", "Unkown Exception occurred. Please check log files for the cause or contact your Administrator");

	private String code;
	private String description;

	private ResponseCodes(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

}
