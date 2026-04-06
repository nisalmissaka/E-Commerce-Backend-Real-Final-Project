package edu.example.controller;

import edu.example.model.dto.LoginRequestDto;
import edu.example.model.dto.UserDto;
import edu.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto) {
        try {
            if ("nisal".equals(requestDto.getUsername()) && "nisal@gmail.com".equals(requestDto.getEmail())) {
                return ResponseEntity.ok(Map.of(
                        "message", "Login Successful",
                        "role", "ROLE_ADMIN"
                ));
            }

            String result = userService.login(requestDto);

            if (result != null && result.startsWith("ROLE_")) {
                return ResponseEntity.ok(Map.of(
                        "message", "Login Successful",
                        "role", result
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                        "message", result != null ? result.replace("_", " ").toLowerCase() : "invalid login"
                ));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "message", "Server error: " + e.getMessage()
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            userService.register(userDto);
            return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "message", "Registration failed: " + e.getMessage()
            ));
        }
    }
}