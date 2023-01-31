package com.examen.java.crud.springapp.exceptions;

public class InternalServerError extends CrudException {

    public InternalServerError(String message) {
        super(500, "INTERNAL_SERVER_ERROR", message);
    }
}
