package com.transport.transport_api.driver.service;

import com.transport.transport_api.driver.dto.DriverRequest;
import com.transport.transport_api.driver.dto.DriverResponse;
import com.transport.transport_api.driver.entity.Driver;
import com.transport.transport_api.driver.mapper.DriverMapper;
import com.transport.transport_api.driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Transactional
    public DriverResponse create(DriverRequest request) {

        Driver driver = driverMapper.toEntity(request);

        driver.setId(UUID.randomUUID());

        driver.setActive(true);

        return driverMapper.toResponse(driverRepository.save(driver));
    }


    @Transactional(readOnly = true)
    public List<DriverResponse> findActive() {

        return driverRepository.findByActiveTrue().stream()
                .map(driverMapper::toResponse)
                .toList();
    }
}
