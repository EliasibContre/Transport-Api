package com.transport.transport_api.assignment.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AssignmentResponse(
        UUID id,
        UUID orderId,
        UUID driverId,
        OffsetDateTime assignedAt
) {
}
