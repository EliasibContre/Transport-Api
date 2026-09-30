package com.transport.transport_api.order.dto;

import com.transport.transport_api.order.enums.OrderStatus;

import java.time.OffsetDateTime;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        OrderStatus status,
        String origin,
        String destination,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
