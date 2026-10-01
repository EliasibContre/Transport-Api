package com.transport.transport_api.driver.dto;

import jakarta.validation.constraints.NotBlank;

public record DriverRequest(
        @NotBlank
        String name,
        @NotBlank
        String licenseNumber
) {
}
