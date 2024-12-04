package com.oumaima.pigeonSecure.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDTO<T> {
    private final boolean success;
    private final T data;
    private final String error;
    private final int status;


    public static <T> ApiResponseDTO<T> success(T data, int status) {
        return new ApiResponseDTO<>(true, data, null, status);
    }


    public static <T> ApiResponseDTO<T> error(String message, int status) {
        return new ApiResponseDTO<>(false, null, message, status);
    }


    public static <T> ApiResponseDTO<T> ok(T body) {
        return new ApiResponseDTO<>(true, body, null, HttpStatus.OK.value());
    }


    public static <T> ApiResponseDTO<T> notFound() {
        return new ApiResponseDTO<>(false, null, "Resource not found", HttpStatus.NOT_FOUND.value());
    }

}
