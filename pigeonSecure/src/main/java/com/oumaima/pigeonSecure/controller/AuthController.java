package com.oumaima.pigeonSecure.controller;

import com.oumaima.pigeonSecure.dto.ApiResponseDTO;
import com.oumaima.pigeonSecure.dto.user.*;
import com.oumaima.pigeonSecure.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponse = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<ApiResponseDTO<String>> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(ApiResponseDTO.ok("User logged in successfully: " + authentication.getName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponseDTO.unauthorized("User is not authenticated"));
    }

}
