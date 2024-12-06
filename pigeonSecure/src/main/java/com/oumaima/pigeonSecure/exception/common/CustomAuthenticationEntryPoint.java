package com.oumaima.pigeonSecure.exception.common;

git
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
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        log.info(authException.getClass().getSimpleName());

        StringBuilder responseBody = new StringBuilder();
        responseBody.append("{\"error\": \"Unauthorized Access\", ");

        if(authException instanceof BadCredentialsException) {
            responseBody.append("\"message\": \"Bad credentials.\", ");
        } else {
            responseBody.append("\"message\": \"You must be authenticated to access this resource.\", ");
        }

        responseBody.append("\"status\": \"")
                .append(HttpStatus.UNAUTHORIZED.value())
                .append("\", ").append("\"path\": \"")
                .append(request.getRequestURI()).append("\"}");

        response.getWriter().write(responseBody.toString());
    }
}
