package com.myproject.cloud.domain.model;

import lombok.Data;

@Data
public class SensorAutomationModel {

    private String sensorId;
    private Integer maxHumidity;
    private Integer minHumidity;
    private Integer minPeriod;
    private Integer maxPeriod;
    private Boolean automationEnabled;
    private Boolean applied;
}
