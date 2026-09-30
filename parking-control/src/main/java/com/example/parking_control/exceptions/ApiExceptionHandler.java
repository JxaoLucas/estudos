package com.example.parking_control.exceptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, List<String>> erros = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(e -> erros.computeIfAbsent(e.getField(), k -> new ArrayList<>()).add(e.getDefaultMessage()));

        ex.getBindingResult().getGlobalErrors().forEach(
                e -> erros.computeIfAbsent(e.getObjectName(), k -> new ArrayList<>()).add(e.getDefaultMessage()));

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", 400);
        body.put("mensagem", "Erro de validação");
        body.put("erros", erros);

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro: placa ou número da vaga já está em uso por outro registro");
    }
}