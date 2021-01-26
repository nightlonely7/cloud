package com.myproject.cloud.request;

import lombok.Data;

@Data
public class SensorAutomationCreateRequest {

    private Integer minHumidity;
    private Integer maxHumidity;
    private Integer minPeriod;
    private Integer maxPeriod;
    private Boolean automationEnabled;
}
