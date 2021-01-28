package com.myproject.cloud.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SensorAutomationGetAllResponse extends BaseResponse {
    private List<SensorAutomationBasicResponse> data;
}
