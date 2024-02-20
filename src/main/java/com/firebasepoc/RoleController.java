package com.firebasepoc;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/grant-admin/{email}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> grantAdminRole(@PathVariable String email) throws FirebaseAuthException {
        roleService.grantAdminRole(email);
        return ResponseEntity.ok("Granted admin role to [" + email + "]");
    }

    @PostMapping("/revoke-admin/{email}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> revokeAdminRole(@PathVariable String email) throws FirebaseAuthException {
        roleService.revokeAdminRole(email);
        return ResponseEntity.ok("Revoked admin role from [" + email + "]");
    }

    @PostMapping("/grant-editor/{email}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> grantEditorRole(@PathVariable String email) throws FirebaseAuthException {
        roleService.grantEditorRole(email);
        return ResponseEntity.ok("Granted editor role to [" + email + "]");
    }

    @PostMapping("/revoke-editor/{email}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> revokeEditorRole(@PathVariable String email) throws FirebaseAuthException {
        roleService.revokeEditorRole(email);
        return ResponseEntity.ok("Revoked editor role from [" + email + "]");
    }
}
