package com.heffdev.fit.dto;

import com.heffdev.fit.util.ResponseCodes;

public class CheckHealthResponse extends PModuleResponse {

	public CheckHealthResponse() {
		super();
	}

	public CheckHealthResponse(ResponseCodes rc) {
		super();
		this.setResponseCode(rc);

	}

}
