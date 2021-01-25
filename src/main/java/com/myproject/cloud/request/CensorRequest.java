package com.myproject.cloud.request;

import lombok.Data;

@Data
public class CensorRequest {

    private String censorId;
    private String censorValue;
    private long measureTime;
    private String userId;
}
