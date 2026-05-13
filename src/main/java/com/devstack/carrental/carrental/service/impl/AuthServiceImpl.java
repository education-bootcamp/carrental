package com.devstack.carrental.carrental.service.impl;

import com.devstack.carrental.carrental.dto.request.LoginRequestDTO;
import com.devstack.carrental.carrental.dto.request.RegisterRequestDTO;
import com.devstack.carrental.carrental.dto.response.AuthResponseDTO;
import com.devstack.carrental.carrental.entity.User;
import com.devstack.carrental.carrental.exception.DuplicateEntryException;
import com.devstack.carrental.carrental.repository.UserRepository;
import com.devstack.carrental.carrental.service.AuthService;
import com.devstack.carrental.carrental.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository systemUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public void register(RegisterRequestDTO dto) {
        if (systemUserRepo.existsByEmail(dto.getEmail())){
            throw new DuplicateEntryException("Email is Already exists");
        }

        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .passwordHash(passwordEncoder.encode(dto.getPassword()))
                .phone(dto.getPhoneNumber())
                .role(User.Role.CUSTOMER)
                .isActive(true)
                .emailVerified(false)
                .build();

        systemUserRepo.save(user);

    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(), dto.getPassword()
                )
        );
        User systemUser = systemUserRepo.findSystemUserByEmail((dto.getEmail()))
                .orElseThrow(()-> new RuntimeException("User not found"));

        String token = jwtUtil.generateAccessToken(systemUser);
        return AuthResponseDTO.builder()
                .role(systemUser.getRole().name())
                .token(token)
                .tokenType("Bearer")
                .fullName(systemUser.getFullName())
                .email(systemUser.getEmail())
                .build();
    }
}
