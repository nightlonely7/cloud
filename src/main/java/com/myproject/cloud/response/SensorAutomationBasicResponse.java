package com.myproject.cloud.response;

import lombok.Data;

@Data
public class SensorAutomationBasicResponse implements DataResponse {

    private String sensorId;
    private String sensorAutomationId;
    private String sensorAutomationName;
    private Integer minHumidity;
    private Integer maxHumidity;
    private Integer minPeriod;
    private Integer maxPeriod;
    private Boolean automationEnabled;
    private Boolean applied;
}
