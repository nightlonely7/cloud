package com.myproject.cloud.domain.repository;

import com.myproject.cloud.domain.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorRepository extends JpaRepository<SensorEntity, UUID> {
}
