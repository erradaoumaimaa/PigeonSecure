package com.oumaima.pigeonSecure.exception.common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        log.info(authException.getClass().getSimpleName());

        StringBuilder responseBody = new StringBuilder();
        responseBody.append("{\"error\": \"Unauthorized Access\", ");

        if(authException instanceof BadCredentialsException) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            responseBody.append("\"message\": \"Bad credentials.\", ")
                    .append("\"status\": \"")
                    .append(HttpStatus.BAD_REQUEST.value());
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            responseBody.append("\"message\": \"You must be authenticated to access this resource.\", ")
                    .append("\"status\": \"")
                    .append(HttpStatus.FORBIDDEN.value());
        }

        responseBody
                .append("\", ").append("\"path\": \"")
                .append(request.getRequestURI()).append("\"}");

        response.getWriter().write(responseBody.toString());
    }
}