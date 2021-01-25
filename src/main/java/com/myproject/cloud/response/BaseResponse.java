package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class BaseResponse {

    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DataResponse data;
}
