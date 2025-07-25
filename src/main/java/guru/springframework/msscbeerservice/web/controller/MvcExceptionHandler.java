package guru.springframework.msscbeerservice.web.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * MvcExceptionHandler handles exceptions thrown by the controllers in the application.
 * It provides custom responses for validation errors and binding exceptions.
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<List> bindExceptionHandler(BindException ex) {
        return new ResponseEntity<>(ex.getAllErrors(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<List> notFoundExceptionHandler(BindException ex) {
        return new ResponseEntity<>(ex.getAllErrors(),HttpStatus.NOT_FOUND);
    }
}
