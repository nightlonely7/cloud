package com.myproject.cloud.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SensorAutomationCreateResponse extends BaseResponse {
    private SensorAutomationBasicResponse data;
}
