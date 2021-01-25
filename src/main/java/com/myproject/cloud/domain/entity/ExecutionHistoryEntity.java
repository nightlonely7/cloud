package com.myproject.cloud.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "execution_history")
public class ExecutionHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "humidity_at_time")
    private Integer humidityAtTime;

    @Column(name = "execution_time")
    private LocalDateTime executionTime;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedTime;
}
