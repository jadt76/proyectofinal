package com.shaddai.proyectofinal.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    private String jwtSecret = "yourSecretKey";
    private int jwtExpirationMs = 86400000; // 24 horas

    public String generateJwtToken(Authentication authentication) {
        // Implementación para generar token
    }

    public String getUserNameFromJwtToken(String token) {
        // Obtener username desde token
    }

    public boolean validateJwtToken(String authToken) {
        // Validar token
    }
}
