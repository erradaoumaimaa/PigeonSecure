package com.oumaima.pigeonSecure.security;

import com.oumaima.pigeonSecure.service.user.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, CustomAuthenticationProvider customAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v2/auth/register").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v2/pigeons").hasRole("USER")
                        .requestMatchers("/api/v2/competitions").hasRole("ORGANIZER")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {})
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                            response.getWriter().write("Invalid credentials. Please check your username and password.");
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpStatus.FORBIDDEN.value());
                            response.getWriter().write("Access Denied: You do not have permission to access this resource.");
                        })
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationManager(authenticationManager());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Collections.singletonList(customAuthenticationProvider));
    }

    @Profile("test")
    @Bean
    public PasswordEncoder testPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}