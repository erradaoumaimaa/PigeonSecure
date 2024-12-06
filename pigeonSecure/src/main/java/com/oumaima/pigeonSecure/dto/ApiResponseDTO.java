package com.oumaima.pigeonSecure.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDTO<T> {
    private final boolean success;
    private final T data;
    private final String error;
    private final int status;
    private final String timestamp;


    public static <T> ApiResponseDTO<T> success(T data, int status) {
        return new ApiResponseDTO<>(true, data, null, status, LocalDateTime.now().toString());
    }

    public static <T> ApiResponseDTO<T> error(String message, int status) {
        return new ApiResponseDTO<>(false, null, message, status, LocalDateTime.now().toString());
    }

    // statut : 200 OK
    public static <T> ApiResponseDTO<T> ok(T body) {
        return success(body, HttpStatus.OK.value());
    }

    //  statut :404 Not Found
    public static <T> ApiResponseDTO<T> notFound(String message) {
        return error(message, HttpStatus.NOT_FOUND.value());
    }

    // statut : 400 Bad Request
    public static <T> ApiResponseDTO<T> badRequest(String message) {
        return error(message, HttpStatus.BAD_REQUEST.value());
    }

    //  statut : 401 Unauthorized
    public static <T> ApiResponseDTO<T> unauthorized(String message) {
        return error(message, HttpStatus.UNAUTHORIZED.value());
    }


}
