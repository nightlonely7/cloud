package com.myproject.cloud.repository;

import com.myproject.cloud.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SensorDataRepository extends JpaRepository<SensorDataEntity, UUID> {
    List<SensorDataEntity> findAllByOrderByCreatedTimeDesc();
    List<SensorDataEntity> findAllBySensorIdOrderByCreatedTimeDesc(String sensorId);
}
