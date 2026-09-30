package com.transport.transport_api.order.mapper;


import com.transport.transport_api.order.dto.OrderRequest;
import com.transport.transport_api.order.dto.OrderResponse;
import com.transport.transport_api.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Order toEntity (OrderRequest request);

    OrderResponse toResponse(Order entity);


}
