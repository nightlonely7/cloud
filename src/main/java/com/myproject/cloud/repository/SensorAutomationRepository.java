package com.myproject.cloud.repository;

import com.myproject.cloud.entity.SensorAutomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SensorAutomationRepository extends JpaRepository<SensorAutomationEntity, UUID> {
    Optional<SensorAutomationEntity> findBySensorId(String sensorId);
    Optional<SensorAutomationEntity> findBySensorAutomationId(String sensorId);
}
