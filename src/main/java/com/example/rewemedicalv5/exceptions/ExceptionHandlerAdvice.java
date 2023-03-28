package com.example.rewemedicalv5.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFound e,
            HttpServletRequest request
    ) {
        return buildResponse(new ErrorResponse(
                request.getRequestURI(),
                NOT_FOUND,
                NOT_FOUND.value(),
                e.getMessage()
        ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException e,
            HttpServletRequest request
    ) {
        return buildResponse(new ErrorResponse(
                request.getRequestURI(),
                BAD_REQUEST,
                BAD_REQUEST.value(),
                mapViolations(e)
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArguments(
            MethodArgumentNotValidException e,
            HttpServletRequest request
    ) {
        return buildResponse(new ErrorResponse(
                request.getRequestURI(),
                BAD_REQUEST,
                BAD_REQUEST.value(),
                "Invalid arguments",
                mapValidationErrors(e)
        ));
    }

    private static HashMap<String, String> mapValidationErrors(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, String>();

        e.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errors.put(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        )
                );

        return errors;
    }

    private static String mapViolations(ConstraintViolationException e) {
        return e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private ResponseEntity<Object> buildResponse(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
