package com.bhagya.learning.crud.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles exception Globally.
 * This class handles various Exceptions and constructs an error message.
 *
 * @return a ResponseEntity with a string of error messages
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method handles various Exceptions and constructs an error message.
     *
     * @param ex the PartNotFoundException containing the error details
     * @return a ResponseEntity with a string of error messages
     */
    @ExceptionHandler(PartNotFoundException.class)
    public ResponseEntity<String> partNotFoundHandler(PartNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles various Exceptions and constructs an error message.
     *
     * @param ex the PartAlreadyExistException containing the error details
     * @return a ResponseEntity with a string of error messages
     */
    @ExceptionHandler(PartAlreadyExistException.class)
    public ResponseEntity<String> PartAlreadyExitExceptionHandler(PartAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * method used to handle the exception occuring due to input validation
     *
     * @param ex the instance containing validation error details
     * @param headers to be written to the response.
     * @param status statusCode of request
     * @param request current  WebRequest
     * @return list of erros with specific status code.
     */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
