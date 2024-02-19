package com.firebasepoc;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleService {
    private final FirebaseConfig firebaseConfig;

    public RoleService(FirebaseConfig firebaseConfig) {
        this.firebaseConfig = firebaseConfig;
    }

    public void grantAdminRole(String email) throws FirebaseAuthException {
        setRole(email, "admin", true);
    }

    public void revokeAdminRole(String email) throws FirebaseAuthException {
        setRole(email, "admin", false);
    }

    private void setRole(String email, String role, boolean value) throws FirebaseAuthException {
        Map<String, Object> claims = new HashMap<>();
        claims.put(role, value);
        String uid = firebaseConfig.firebaseApp().getUserByEmail(email).getUid();
        firebaseConfig.firebaseApp().setCustomUserClaims(uid, claims);
    }
}
