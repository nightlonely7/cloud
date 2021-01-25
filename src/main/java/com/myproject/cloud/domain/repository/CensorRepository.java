package com.myproject.cloud.domain.repository;

import com.myproject.cloud.domain.entity.CensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CensorRepository extends JpaRepository<CensorEntity, UUID> {
}
