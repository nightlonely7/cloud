package com.myproject.cloud.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorDataCreateRequest {

    private String sensorId;
    private String sensorValue;
    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss")
    private LocalDateTime measureTime;
}
