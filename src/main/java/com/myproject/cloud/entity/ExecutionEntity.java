package com.myproject.cloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "execution")
public class ExecutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "execution_id")
    private String executionId;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "currentHumidity")
    private Integer currentHumidity;

    @Column(name = "targetHumidity")
    private Integer targetHumidity;

    @Column(name = "request_time")
    private LocalDateTime requestTime;

    @Column(name = "execution_time")
    private LocalDateTime executionTime;

    @Column(name = "executed")
    private Boolean executed;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedTime;
}
