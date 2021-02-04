package com.myproject.cloud.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecutionModel {

    private String executionId;
    private String sensorId;
    private Integer currentHumidity;
    private Integer targetHumidity;
    private LocalDateTime executionTime;
    private LocalDateTime requestTime;
    private Boolean executed;
}
