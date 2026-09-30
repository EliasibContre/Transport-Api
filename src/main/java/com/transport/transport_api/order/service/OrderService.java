package com.transport.transport_api.order.service;

import com.transport.transport_api.order.dto.OrderRequest;
import com.transport.transport_api.order.dto.OrderResponse;
import com.transport.transport_api.order.entity.Order;
import com.transport.transport_api.order.enums.OrderStatus;
import com.transport.transport_api.order.mapper.OrderMapper;
import com.transport.transport_api.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;

    @Transactional
    public OrderResponse create (OrderRequest request){
        Order order = orderMapper.toEntity(request);

        order.setId(UUID.randomUUID());

        order.setStatus(OrderStatus.CREATED);

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        order.setCreatedAt(now);

        order.setUpdatedAt(now);

        return orderMapper.toResponse(orderRepository.save(order));
    }
}
