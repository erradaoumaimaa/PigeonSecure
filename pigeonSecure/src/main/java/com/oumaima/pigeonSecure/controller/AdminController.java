package com.oumaima.pigeonSecure.controller;

import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.exception.user.UserNotFoundException;
import com.oumaima.pigeonSecure.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @PatchMapping("/{username}/{role}")
    public ResponseEntity<User> updateRole(@PathVariable String username, @PathVariable String role) {
        try {
            User newRole = userService.updateUserRole(username, role);
            return ResponseEntity.ok(newRole);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

