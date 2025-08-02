package com.shaddai.proyectofinal.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        // Aquí se implementaría la lógica de autenticación JWT
        // Por ejemplo, extraer el token de la cabecera Authorization y validarlo

        filterChain.doFilter(request, response); // Continuar con la cadena de filtros
    }
}
