package com.transport.transport_api.assignment.mapper;


import com.transport.transport_api.assignment.dto.AssignmentFileResponse;
import com.transport.transport_api.assignment.dto.AssignmentRequest;
import com.transport.transport_api.assignment.dto.AssignmentResponse;
import com.transport.transport_api.assignment.entity.Assignment;
import com.transport.transport_api.assignment.entity.AssignmentFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignedAt", ignore = true)
    Assignment toEntity(AssignmentRequest request);

    AssignmentResponse toResponse(Assignment assignment);

    AssignmentFileResponse toFileResponse(AssignmentFile file);

}
