package com.heffdev.fit.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.heffdev.fit.util.ResponseCodes;

public abstract class PModuleResponse {

	private ResponseCodes responseCode;

	private String responseMessage;

	public PModuleResponse() {
		this.responseCode = ResponseCodes.OK;
		this.responseMessage = ResponseCodes.OK.getDescription();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true, null, new String[] {});
	}

	public String getResonseMessage() {
		return this.responseMessage;
	}

	/**
	 * @return the responseCode
	 */
	public ResponseCodes getResponseCode() {
		return this.responseCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	// public void setOkResponse() {
	// this.setResponseCode(ResponseCodes.OK);
	// }

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(ResponseCodes responseCode) {
		this.responseCode = responseCode;
		this.responseMessage = this.responseCode.getDescription();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String toStringJson() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
