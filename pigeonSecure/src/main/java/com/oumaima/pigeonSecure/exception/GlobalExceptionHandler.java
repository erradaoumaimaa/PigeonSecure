package com.oumaima.pigeonSecure.exception;

import com.oumaima.pigeonSecure.dto.ApiResponseDTO;
import com.oumaima.pigeonSecure.exception.user.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ApiResponseDTO<String> handleUsernameAlreadyExistsException(UserAlreadyExistsException ex) {
        return ApiResponseDTO.error(ex.getMessage(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponseDTO<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ApiResponseDTO.error(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponseDTO<String> handleGeneralException(Exception ex) {
        return ApiResponseDTO.error("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
