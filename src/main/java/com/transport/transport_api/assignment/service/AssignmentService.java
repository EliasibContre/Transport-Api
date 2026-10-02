package com.transport.transport_api.assignment.service;

import com.transport.transport_api.assignment.dto.AssignmentRequest;
import com.transport.transport_api.assignment.dto.AssignmentResponse;
import com.transport.transport_api.assignment.entity.Assignment;
import com.transport.transport_api.assignment.mapper.AssignmentMapper;
import com.transport.transport_api.assignment.repository.AssignmentRepository;
import com.transport.transport_api.driver.entity.Driver;
import com.transport.transport_api.driver.repository.DriverRepository;
import com.transport.transport_api.order.entity.Order;
import com.transport.transport_api.order.enums.OrderStatus;
import com.transport.transport_api.order.repository.OrderRepository;
import com.transport.transport_api.shared.error.ApplicationException;
import com.transport.transport_api.shared.error.ApplicationException.Reason;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final OrderRepository orderRepository;
    private final DriverRepository driverRepository;
    private final AssignmentMapper assignmentMapper;

    @Transactional
    public AssignmentResponse create(AssignmentRequest request) {
        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new ApplicationException(
                        Reason.RESOURCE_NOT_FOUND,
                        "No existe la orden con ID " +
                                request.orderId()));

        Driver driver = driverRepository.findById(request.driverId())
                .orElseThrow(() -> new ApplicationException(
                        Reason.RESOURCE_NOT_FOUND,
                        "No existe el conductor con ID " +
                                request.driverId()));

        if (order.getStatus() != OrderStatus.CREATED) {
            throw new ApplicationException(
                    Reason.BUSINESS_RULE,
                    "Solo se pueden asignar órdenes en estado CREATED");
        }

        if (!driver.isActive()) {
            throw new ApplicationException(
                    Reason.BUSINESS_RULE,
                    "El conductor debe estar activo");
        }

        if (assignmentRepository.existsByOrderId(order.getId())) {
            throw new ApplicationException(
                    Reason.BUSINESS_RULE,
                    "La orden ya tiene un conductor asignado");
        }

        Assignment assignment = assignmentMapper.toEntity(request);
        assignment.setId(UUID.randomUUID());
        assignment.setAssignedAt(OffsetDateTime.now(ZoneOffset.UTC));

        return assignmentMapper.toResponse(
                assignmentRepository.saveAndFlush(assignment));
    }
}