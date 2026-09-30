package com.transport.transport_api.order.dto;

import com.transport.transport_api.order.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderStatusRequest(
        @NotNull
        OrderStatus status
) {
}
