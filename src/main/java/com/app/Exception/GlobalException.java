package com.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(EntryException.class)
	public ResponseEntity<ErrorDetails> handleEntryException(EntryException entryException, WebRequest wr)
	{
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),entryException.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleEntryException(Exception exception, WebRequest wr)
	{
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
	

}
