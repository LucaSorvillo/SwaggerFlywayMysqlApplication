package it.company.project.controller;

import it.company.project.dto.ErrorDTO;
import it.company.project.exception.ApplicationException;
import it.company.project.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<Object> getResponseException(ApplicationException exception) {
		log.error("Exception handled: " + exception.getErrorMessage());
		log.error("Exception handled: ", exception);
		return generateResponse(exception);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> getResponseUnhandledException(Exception exception) {
		log.error("Exception not handled: " + exception.getMessage());
		log.error("Exception not handled: ", exception);
		return generateResponse(new ServerException(exception));
	}
	
	private ResponseEntity<Object> generateResponse(ApplicationException exception) {
		ErrorDTO dto = new ErrorDTO(exception.getHttpCode(), exception.getErrorMessage());
		return ResponseEntity.status(exception.getHttpCode()).body(dto);
	}
	
}

