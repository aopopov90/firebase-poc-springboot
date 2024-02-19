package com.firebasepoc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Optional;

public class AuthContextUtils {

    public enum UserType {
        ANONYMOUS
    }

    public static String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isJwtAuthenticated(authentication)) {
            return getJwt().getClaimAsString("email");
        }
        return String.valueOf(UserType.ANONYMOUS);
    }

    public static Boolean isAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isJwtAuthenticated(authentication)) {
            return Optional.ofNullable(getJwt())
                    .map(j -> "true".equals(j.getClaimAsString("admin")))
                    .orElse(false);
        }
        return false;
    }

    private static boolean isJwtAuthenticated(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated() && authentication instanceof JwtAuthenticationToken;
    }

    private static Jwt getJwt() {
        return ((JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getToken();
    }
}
