package com.myproject.cloud.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecutionUpdateRequest {

    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss")
    private LocalDateTime executionTime;
    private Boolean executed;
}
