package com.devstack.carrental.carrental.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponseDTO {
    private int code;
    private String message;
    private Object data;
}
