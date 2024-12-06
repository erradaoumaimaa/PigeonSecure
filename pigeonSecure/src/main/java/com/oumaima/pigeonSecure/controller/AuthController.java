package com.oumaima.pigeonSecure.controller;

import com.oumaima.pigeonSecure.dto.user.UserRequestDTO;
import com.oumaima.pigeonSecure.dto.user.UserResponseDTO;
import com.oumaima.pigeonSecure.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            return "User logged in successfully: " + authentication.getName();
        }
        return "User is not authenticated";
    }
}
