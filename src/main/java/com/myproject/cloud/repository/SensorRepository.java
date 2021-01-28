package com.myproject.cloud.repository;

import com.myproject.cloud.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorRepository extends JpaRepository<SensorEntity, UUID> {
}
