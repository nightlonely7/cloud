package com.myproject.cloud.request;

import lombok.Data;

@Data
public class SensorAutomationCreateRequest {

    private String sensorId;
    private String sensorAutomationName;
    private Integer minHumidity;
    private Integer maxHumidity;
    private Integer minPeriod;
    private Integer maxPeriod;
    private Boolean automationEnabled;
    private Boolean applied;
}
