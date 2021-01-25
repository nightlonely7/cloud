package com.myproject.cloud.controller;

import com.myproject.cloud.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<BaseResponse> handleThrowAble(Throwable throwable){

        log.error("throwable exception.", throwable);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(1001);
        baseResponse.setMessage("Server error.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseResponse);
    }
}
