package com.myproject.cloud.domain.repository;

import com.myproject.cloud.domain.entity.SensorAutomationEntity;
import com.myproject.cloud.domain.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SensorAutomationRepository extends JpaRepository<SensorAutomationEntity, UUID> {
    Optional<SensorAutomationEntity> findBySensorId(String sensorId);
}
