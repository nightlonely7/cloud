package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.domain.service.SensorDataService;
import com.myproject.cloud.request.CensorRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.CensorResponse;
import com.myproject.cloud.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/censorData")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @PostMapping
    public ResponseEntity<BaseResponse> censor(@RequestBody CensorRequest censorRequest) throws URISyntaxException {
        sensorDataService.validateSensorRequest(censorRequest);
        SensorDataModel sensorDataModel = sensorDataService.convertSensorRequest(censorRequest);
        sensorDataService.saveSensorData(sensorDataModel);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("censor create success.");
        DataResponse dataResponse = new CensorResponse();
        baseResponse.setData(dataResponse);
        return ResponseEntity.created(new URI("/censorData")).body(baseResponse);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllCensor() {

        List<SensorDataModel> listCensor = sensorDataService.getAllSensorData();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("get all success.");
        CensorResponse dataResponse = new CensorResponse();
        dataResponse.setListCensor(listCensor);
        baseResponse.setData(dataResponse);
        return ResponseEntity.ok(baseResponse);
    }
}
