package com.crystalark.userservice.Exceptions;

import com.crystalark.userservice.controllers.UserController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({ Exception.class })
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return exceptionResponseWithHateoasLinks(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
                request.getDescription(false));
    }

    @ExceptionHandler({ UserNotFoundException.class })
    public final ResponseEntity<Object> handleAllUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
        return exceptionResponseWithHateoasLinks(ex.getMessage(), HttpStatus.NOT_FOUND, request.getDescription(false));
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return exceptionResponseWithHateoasLinks("Input Validation Failed", HttpStatus.BAD_REQUEST,
                ex.getBindingResult().getAllErrors().toString());
    }

    public final ResponseEntity<Object> exceptionResponseWithHateoasLinks(String message, HttpStatus responseHttpStatus,
            String errorDetails) {
        CustomExceptionResponse exceptionResponse = new CustomExceptionResponse(new Date(), message, errorDetails);
        Resource<CustomExceptionResponse> resource = new Resource<>(exceptionResponse);
        resource.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-Users"));
        resource.add(linkTo(methodOn(UserController.class).getHomePage()).withRel("home"));
        return new ResponseEntity<>(resource, responseHttpStatus);
    }
}
