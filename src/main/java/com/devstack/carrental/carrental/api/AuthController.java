package com.devstack.carrental.carrental.api;

import com.devstack.carrental.carrental.dto.request.LoginRequestDTO;
import com.devstack.carrental.carrental.dto.request.RegisterRequestDTO;
import com.devstack.carrental.carrental.dto.response.AuthResponseDTO;
import com.devstack.carrental.carrental.dto.response.StandardResponseDTO;
import com.devstack.carrental.carrental.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponseDTO> register
            (@Valid @RequestBody RegisterRequestDTO dto){
        authService.register(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StandardResponseDTO.builder()
                        .code(201)
                        .message("User created successfully")
                        .data(null)
                        .build());
    }

    @PostMapping("/login")
    public ResponseEntity<StandardResponseDTO> register
            (@Valid @RequestBody LoginRequestDTO dto){
        AuthResponseDTO login = authService.login(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StandardResponseDTO.builder()
                        .code(201)
                        .message("User successfully logged..")
                        .data(login)
                        .build());
    }



}
