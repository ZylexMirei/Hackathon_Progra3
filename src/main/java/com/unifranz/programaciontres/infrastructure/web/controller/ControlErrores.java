package com.unifranz.programaciontres.infrastructure.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControlErrores {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> recibirError(RuntimeException ex) {
        Map<String, String> res = new HashMap<>();
        res.put("Error", ex.getMessage());
        return ResponseEntity.badRequest().body(res);
    }
}
