package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecutionDataResponse {
    private String executionId;
    private String sensorId;
    private Integer currentHumidity;
    private Integer targetHumidity;
    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss")
    private LocalDateTime executionTime;
    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss")
    private LocalDateTime requestTime;
    private Boolean executed;
}
