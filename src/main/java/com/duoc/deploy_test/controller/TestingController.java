package com.duoc.deploy_test.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/testing")
public class TestingController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(Map.of(
                "method", "GET",
                "message", "TestingController funcionando correctamente",
                "environment", "local/deploy",
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of(
                "method", "GET BY ID",
                "id", id,
                "message", "Consulta por ID funcionando correctamente",
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body) {
        return ResponseEntity.ok(Map.of(
                "method", "POST",
                "message", "Creación funcionando correctamente",
                "receivedBody", body != null ? body : Map.of(),
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody(required = false) Map<String, Object> body) {
        return ResponseEntity.ok(Map.of(
                "method", "PUT",
                "id", id,
                "message", "Actualización funcionando correctamente",
                "receivedBody", body != null ? body : Map.of(),
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of(
                "method", "DELETE",
                "id", id,
                "message", "Eliminación funcionando correctamente",
                "timestamp", LocalDateTime.now().toString()
        ));
    }

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "message", "Aplicación levantada correctamente",
                "timestamp", LocalDateTime.now().toString()
        ));
    }
}
