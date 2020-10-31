package com.eruscupisoss.app.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.eruscupisoss.app.services.exceptions.DatabaseException;
import com.eruscupisoss.app.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ResourceNotFoundException e, HttpServletRequest req){

            String error = "Não encontrado!";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(), status.value(), error , e.getMessage(), req.getRequestURI());

            return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest req){

            String error = "Database ERROR!";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            StandardError err = new StandardError(Instant.now(), status.value(), error , e.getMessage(), req.getRequestURI());

            return ResponseEntity.status(status).body(err);
    }
    
}
