package com.myproject.cloud.repository;

import com.myproject.cloud.entity.ExecutionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExecutionHistoryRepository extends JpaRepository<ExecutionHistoryEntity, UUID> {
}
