package it.company.project.exception;

public class NotFoundException extends ApplicationException {
	
	public NotFoundException(String entityType, Object id) {
		super(404, "Object of type {0} with id {1} not found", entityType, id);
	}

}
