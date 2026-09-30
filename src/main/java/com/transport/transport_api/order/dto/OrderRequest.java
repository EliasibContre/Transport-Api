package com.transport.transport_api.order.dto;

import jakarta.validation.constraints.NotBlank;

public record OrderRequest(
        @NotBlank
        String origin,
        @NotBlank
        String destination
) {
}
