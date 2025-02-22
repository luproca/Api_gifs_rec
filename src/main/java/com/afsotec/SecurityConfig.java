package com.afsotec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login",
                                "/api/auth/login",
                                "/api/auth/forgot-password",
                                "/api/auth/verify-otp",
                                "/api/auth/reset-password",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/api/consulta-ahorros/**", // Asegúrate de que esta ruta esté pública
                                "/test" // Agrega esta línea para permitir acceso público al endpoint de prueba
                        ).permitAll()
                        .anyRequest().authenticated() // Opcional: Solo si quieres que otros endpoints requieran autenticación
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // Desactiva autenticación básica
        return http.build();
    }
}