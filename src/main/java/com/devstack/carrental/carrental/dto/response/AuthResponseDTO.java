package com.devstack.carrental.carrental.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponseDTO {
    private String token;
    private String tokenType;
    private String email;
    private String fullName;
    private String role;
}
