package br.com.example.springjpa.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.example.springjpa.services.exceptions.ControllerNotFoundException;
import br.com.example.springjpa.services.exceptions.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExecptionHandler {

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> controllerNotFound(ControllerNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), 
            status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), 
            status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}
