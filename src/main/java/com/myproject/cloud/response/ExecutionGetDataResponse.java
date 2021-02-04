package com.myproject.cloud.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExecutionGetDataResponse extends BaseResponse {
    private List<ExecutionDataResponse> data;
}
