package com.myproject.cloud.repository;

import com.myproject.cloud.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorDataRepository extends JpaRepository<SensorDataEntity, UUID> {
}
