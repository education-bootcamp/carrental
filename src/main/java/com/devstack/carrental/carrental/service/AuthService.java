package com.devstack.carrental.carrental.service;


import com.devstack.carrental.carrental.dto.request.LoginRequestDTO;
import com.devstack.carrental.carrental.dto.request.RegisterRequestDTO;
import com.devstack.carrental.carrental.dto.response.AuthResponseDTO;

public interface AuthService {
    void register(RegisterRequestDTO dto);
    AuthResponseDTO login(LoginRequestDTO dto);
}
