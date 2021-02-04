package com.myproject.cloud.repository;

import com.myproject.cloud.entity.ExecutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExecutionRepository extends JpaRepository<ExecutionEntity, UUID> {
    Optional<ExecutionEntity> findByExecutionId(String executionId);
    List<ExecutionEntity> findAllByOrderByCreatedTimeDesc();

}
