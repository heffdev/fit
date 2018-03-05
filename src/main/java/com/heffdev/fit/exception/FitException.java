package com.heffdev.fit.exception;

import com.heffdev.fit.util.ResponseCodes;

public class FitException extends Exception {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private ResponseCodes code;

	public FitException(ResponseCodes code) {
		super();
		this.code = code;
	}

	public FitException(ResponseCodes code, Throwable cause) {
		super();
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public ResponseCodes getCode() {
		return this.code;
	}

}
