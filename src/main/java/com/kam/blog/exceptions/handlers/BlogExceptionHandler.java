package com.kam.blog.exceptions.handlers;

import com.kam.blog.exceptions.ErrorMessage;
import com.kam.blog.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException (ResourceNotFoundException exception, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message(exception.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> blogExceptionHandler(Exception exception, WebRequest request){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .message(exception.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
