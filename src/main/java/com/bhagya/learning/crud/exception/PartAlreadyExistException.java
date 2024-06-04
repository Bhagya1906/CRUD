package com.bhagya.learning.crud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = ".....")
public class PartAlreadyExistException extends RuntimeException {
    public PartAlreadyExistException(final String msg) {
        super(msg);
    }
}
