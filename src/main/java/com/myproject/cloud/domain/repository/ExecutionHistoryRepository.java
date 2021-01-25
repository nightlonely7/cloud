package com.myproject.cloud.domain.repository;

import com.myproject.cloud.domain.entity.ExecutionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExecutionHistoryRepository extends JpaRepository<ExecutionHistoryEntity, UUID> {
}
