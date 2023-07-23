package com.EMB.app_EMB.Exception;

import com.EMB.app_EMB.Exception.ControllerExceptions.ViolationException;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RessourceNotFoundException.class, ViolationException.class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // Ajoutez d'autres méthodes d'exception ici, si nécessaire

}
