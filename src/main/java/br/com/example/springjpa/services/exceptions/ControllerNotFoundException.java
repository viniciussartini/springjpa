package br.com.example.springjpa.services.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ControllerNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}