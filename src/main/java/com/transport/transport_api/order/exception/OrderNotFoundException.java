package com.transport.transport_api.order.exception;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID id){
        super("No existe la orden con ID" + id);
    }
}
