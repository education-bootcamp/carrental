package com.devstack.carrental.carrental.dto.response;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginatedResponseDTO<T> {
    private long count;
    private List<T> dataList;
}
