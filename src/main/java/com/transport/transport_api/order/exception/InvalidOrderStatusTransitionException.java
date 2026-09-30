package com.transport.transport_api.order.exception;

import com.transport.transport_api.order.enums.OrderStatus;

public class InvalidOrderStatusTransitionException extends RuntimeException{
    public InvalidOrderStatusTransitionException (OrderStatus current, OrderStatus next){
        super("No se permite cambiar la orden de " + current + " a " + next);
    }
}
