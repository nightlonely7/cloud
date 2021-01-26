package com.myproject.cloud.request;

import lombok.Data;

@Data
public class SensorAutomationUpdateRequest {

    private Integer maxHumidity;
    private Integer minHumidity;
    private Integer minPeriod;
    private Integer maxPeriod;
    private Boolean automationEnabled;
}
