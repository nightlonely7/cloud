package com.myproject.cloud.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecutionCreateRequest {

    private String sensorId;
    private Integer currentHumidity;
    private Integer targetHumidity;
    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss")
    private LocalDateTime requestTime;
}
