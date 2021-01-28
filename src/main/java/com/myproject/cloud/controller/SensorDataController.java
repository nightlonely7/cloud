package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.response.SensorDataGetAllResponse;
import com.myproject.cloud.service.SensorDataService;
import com.myproject.cloud.request.SensorDataCreateRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.SensorDataBasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sensorData")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @PostMapping
    public ResponseEntity<BaseResponse> createSensorData(@RequestBody SensorDataCreateRequest sensorDataCreateRequest) throws URISyntaxException {
        sensorDataService.validateSensorRequest(sensorDataCreateRequest);
        SensorDataModel sensorDataModel = sensorDataService.convertSensorRequest(sensorDataCreateRequest);
        sensorDataService.saveSensorData(sensorDataModel);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("sensor create success.");
        SensorDataBasicResponse dataResponse = new SensorDataBasicResponse();
//        baseResponse.setData(dataResponse);
        return ResponseEntity.created(new URI("/sensorData")).body(baseResponse);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllCensorData() {

        List<SensorDataModel> sensorDataModelList = sensorDataService.getAllSensorData();
        SensorDataGetAllResponse sensorDataGetAllResponse = new SensorDataGetAllResponse();
        sensorDataGetAllResponse.setCode(0);
        sensorDataGetAllResponse.setMessage("get all success.");
        List<SensorDataBasicResponse> sensorDataBasicResponseList = sensorDataModelList.stream().map(sensorDataModel -> {
            SensorDataBasicResponse sensorDataBasicResponse = new SensorDataBasicResponse();
            sensorDataBasicResponse.setSensorId(sensorDataModel.getSensorId());
            sensorDataBasicResponse.setSensorValue(sensorDataModel.getSensorValue());
            sensorDataBasicResponse.setMeasureTime(sensorDataModel.getMeasureTime());
            return sensorDataBasicResponse;
        }).collect(Collectors.toList());
        sensorDataGetAllResponse.setData(sensorDataBasicResponseList);
        return ResponseEntity.ok(sensorDataGetAllResponse);
    }
}
