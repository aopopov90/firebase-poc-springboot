package com.firebasepoc;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseAuth firebaseApp() {
        FirebaseApp firebaseApp = FirebaseApp.initializeApp();
        return FirebaseAuth.getInstance(firebaseApp);
    }
}
