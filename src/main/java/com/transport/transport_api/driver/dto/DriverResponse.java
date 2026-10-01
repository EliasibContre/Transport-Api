package com.transport.transport_api.driver.dto;

import java.util.UUID;

public record DriverResponse(

        UUID id,
        String name,
        String licenseNumber,
        boolean active

) {
}
