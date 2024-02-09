package com.firebasepoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }

    @PostMapping("/hello")
    public ResponseEntity<String> helloPost() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }
}
