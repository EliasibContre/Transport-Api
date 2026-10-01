package com.transport.transport_api.driver.mapper;

import com.transport.transport_api.driver.dto.DriverRequest;
import com.transport.transport_api.driver.dto.DriverResponse;
import com.transport.transport_api.driver.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Driver toEntity (DriverRequest request);

    DriverResponse toResponse(Driver driver);
}

