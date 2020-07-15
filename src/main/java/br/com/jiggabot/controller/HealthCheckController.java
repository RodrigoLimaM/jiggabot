package br.com.jiggabot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok().body("Healthy");
    }
}
