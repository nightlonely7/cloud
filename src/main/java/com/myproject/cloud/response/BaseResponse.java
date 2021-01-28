package com.myproject.cloud.response;

import lombok.Data;

@Data
public class BaseResponse {
    private int code;
    private String message;
}
