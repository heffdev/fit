package com.heffdev.sns.dto;

import com.heffdev.sns.util.ResponseCodes;

public class CheckHealthResponse extends PModuleResponse {

	public CheckHealthResponse() {
		super();
	}

	public CheckHealthResponse(ResponseCodes rc) {
		super();
		this.setResponseCode(rc);

	}

}
