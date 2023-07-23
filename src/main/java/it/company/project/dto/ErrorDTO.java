package it.company.project.dto;

public class ErrorDTO {
	
	private Integer httpCode;
	private String errorMessage;
	
	public ErrorDTO(Integer httpCode, String errorMessage) {
		this.httpCode = httpCode;
		this.errorMessage = errorMessage;
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
