package com.curso.dougllas.msclientes.exceptions.handler;

import com.curso.dougllas.msclientes.exceptions.ResourceNotFoundException;
import com.curso.dougllas.msclientes.exceptions.ValidacaoException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiError apiError = new ApiError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(apiError);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ApiError> validation(ValidacaoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiError apiError = new ApiError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(apiError);
    }
}
