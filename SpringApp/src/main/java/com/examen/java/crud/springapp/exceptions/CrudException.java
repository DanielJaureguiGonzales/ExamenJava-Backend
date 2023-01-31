package com.examen.java.crud.springapp.exceptions;

import lombok.Getter;

@Getter
public class CrudException extends Exception {

    private static final long serialVersionUID = 1L;

    private final int code;
    private final String status ;

    public CrudException(int code, String status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

}
