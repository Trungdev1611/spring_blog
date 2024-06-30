package com.example.Blog_model.exception;

import com.example.Blog_model.response.Response;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(DataExists.class)
    public ResponseEntity<Response> handleDataExists(DataExists ex) {
        Response responseError = new Response(0, ex.getMessage(), null);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    //     handle validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        String errors = "";
        // handle includes many errors
        for (FieldError fieldError : fieldErrors) {
            errors = errors + ", " + (fieldError.getDefaultMessage());
        }
        String errorsSubString = errors.substring(2);

        Response errorData = new Response(0, errorsSubString, null );
        return new ResponseEntity<>(errorData, HttpStatus.BAD_REQUEST);
    }

    //Jwt exception
    @ExceptionHandler(JwtExeption.class)
    public ResponseEntity<Response> handleJwtExeption(JwtExeption ex) {
        Response responseError = new Response(0, ex.getMessage(), null);
        return new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
    }

    //NotFound exception
    @ExceptionHandler(NotFoundEx.class)
    public ResponseEntity<Response> handleNotFoundEx(NotFoundEx ex) {
        Response responseError = new Response(0, ex.getMessage(), null);
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);

        });
        Response responseError = new Response(0, "error", errors);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    // exception login
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
        Response responseError = new Response(0, "please check username or password", null);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleOtherExceptions(Exception ex) {
       ex.printStackTrace();

        Response error = new Response(0, ex.getMessage(), null);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
