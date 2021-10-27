package com.datpham.miniblog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityConflictException extends RuntimeException{
    public EntityConflictException(String msg ) {
        super(msg);
    }
}
