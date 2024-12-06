package com.oumaima.pigeonSecure.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        response.getWriter().write("{\"error\": \"Unauthorized Access\", " +
                "\"message\": \"You must be authenticated to access this resource.\", " +
                "\"status\": \"" + HttpStatus.UNAUTHORIZED.value() + "\", " +
                "\"path\": \"" + request.getRequestURI() + "\"}");
    }
}