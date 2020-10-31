package com.eruscupisoss.app.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Não foi possivél encontrar o ID : " + id);
    }
    
}
