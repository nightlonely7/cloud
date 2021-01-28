package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.cloud.domain.model.SensorDataModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SensorDataBasicResponse {
    private String sensorId;
    private String sensorValue;
    private LocalDateTime measureTime;
}
