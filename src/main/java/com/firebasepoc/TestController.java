package com.firebasepoc;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    final private FirebaseConfig firebaseConfig;

    public TestController(FirebaseConfig firebaseConfig) {
        this.firebaseConfig = firebaseConfig;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }

    @PostMapping("/hello")
    public ResponseEntity<String> helloPost() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }

    @GetMapping("/is-admin")
    public ResponseEntity<Boolean> isAdmin() {
        return ResponseEntity.ok(AuthContextUtils.isAdmin());
    }

    @GetMapping("/admin-only")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }

    @GetMapping("/editor-only")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
    public ResponseEntity<String> editorOnly() {
        return ResponseEntity.ok("Hello, " + AuthContextUtils.getCurrentUserEmail());
    }
}
