package com.transport.transport_api.order.controller;


import com.transport.transport_api.order.dto.OrderRequest;
import com.transport.transport_api.order.dto.OrderResponse;
import com.transport.transport_api.order.dto.OrderStatusRequest;
import com.transport.transport_api.order.enums.OrderStatus;
import com.transport.transport_api.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(
            @Valid
            @RequestBody
            OrderRequest request
    ){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(request));
    }

    @PatchMapping("/{id}/status")
    public OrderResponse updateStatus(
            @PathVariable UUID id,
            @Valid @RequestBody OrderStatusRequest request) {
        return orderService.updateStatus(id, request.status());
    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable UUID id){
        return orderService.findById(id);
    }

    @GetMapping
    public List<OrderResponse> findAll(
            @RequestParam(required = false) OrderStatus status,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination
    ){
        return orderService.findAll(status,date,origin,destination);
    }

}
