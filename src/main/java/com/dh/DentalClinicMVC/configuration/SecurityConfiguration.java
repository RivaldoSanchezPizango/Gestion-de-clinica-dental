package com.dh.DentalClinicMVC.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private  JwtAuthenticationFilter jwtAuthenticationFilter;
    private  AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF usando la nueva sintaxis lambda
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/..").permitAll() // Permitir acceso a ciertas rutas
                        .anyRequest().authenticated() // Requiere autenticación para las demás rutas
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configuración de política de sesión sin estado
                )
                .authenticationProvider(authenticationProvider) // Proveedor de autenticación
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Filtro JWT

        return http.build(); // Construcción de la cadena de seguridad
    }

}
