package com.myproject.cloud.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensor_automation")
public class SensorAutomationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "max_humidity")
    private Integer maxHumidity;

    @Column(name = "min_humidity")
    private Integer minHumidity;

    @Column(name = "min_period")
    private Integer minPeriod;

    @Column(name = "max_period")
    private Integer maxPeriod;

    @Column(name = "automation_enabled")
    private Boolean automationEnabled;

    @Column(name = "applied")
    private Boolean applied;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedTime;
}
