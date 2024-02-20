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
        setRole(email, "role_admin", true);
    }

    public void revokeAdminRole(String email) throws FirebaseAuthException {
        setRole(email, "role_admin", false);
    }

    public void grantEditorRole(String email) throws FirebaseAuthException {
        setRole(email, "role_editor", true);
    }

    public void revokeEditorRole(String email) throws FirebaseAuthException {
        setRole(email, "role_editor", false);
    }

    private void setRole(String email, String role, boolean value) throws FirebaseAuthException {
        String uid = firebaseConfig.firebaseApp().getUserByEmail(email).getUid();
        Map<String, Object> existingClaims = new HashMap<>(firebaseConfig.firebaseApp().getUser(uid).getCustomClaims());
        existingClaims.put(role, Boolean.valueOf(value));
        firebaseConfig.firebaseApp().setCustomUserClaims(uid, existingClaims);
    }
}
