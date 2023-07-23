package it.company.project.exception;

public class ServerException extends ApplicationException {
	
	public ServerException(Exception e) {
		super(500, "Internal Server Error. {0}: {1}", e.getClass().getSimpleName(), e.getMessage());
	}
	
}
