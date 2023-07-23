package it.company.project.exception;

import java.text.MessageFormat;

public class ApplicationException extends RuntimeException {
	
	private Integer httpCode;
	private String errorMessage;
	
	public ApplicationException(Integer httpCode, String errorMessage, Object... args) {
		this.httpCode = httpCode;
		this.errorMessage = errorMessage;
		if (args.length > 0) {
			this.errorMessage = MessageFormat.format(errorMessage, args);
		}
	}
	
	public Integer getHttpCode() {
		return httpCode;
	}
	
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
