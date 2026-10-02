package com.transport.transport_api.assignment.repository;

import com.transport.transport_api.assignment.entity.AssignmentFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssignmentFileRepository extends JpaRepository<AssignmentFile, UUID> {
}
