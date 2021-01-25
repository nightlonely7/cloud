package com.myproject.cloud.domain.repository;

import com.myproject.cloud.domain.entity.SensorDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorDataRepository extends JpaRepository<SensorDataEntity, UUID> {
}
