package com.examen.java.crud.springapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends CrudException{

    public ResourceNotFoundException(String message) {
        super(404, "NOT_FOUND", message);
    }
}
