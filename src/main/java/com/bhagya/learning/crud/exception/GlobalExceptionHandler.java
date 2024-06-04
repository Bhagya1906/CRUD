package com.bhagya.learning.crud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles exception Globally.
 * This class handles various Exceptions and constructs an error message.
 *
 * @return a ResponseEntity with a string of error messages
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    /**
     * This method handles various Exceptions and constructs an error message.
     *
     * @param ex the PartNotFoundException containing the error details
     * @return a ResponseEntity with a string of error messages
     *
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
     *
     */
    @ExceptionHandler(PartAlreadyExistException.class)
    public ResponseEntity<String> PartAlreadyExitExceptionHandler(PartAlreadyExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
