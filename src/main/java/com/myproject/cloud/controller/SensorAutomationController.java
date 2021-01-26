package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.SensorAutomationModel;
import com.myproject.cloud.domain.service.SensorAutomationService;
import com.myproject.cloud.request.SensorAutomationCreateRequest;
import com.myproject.cloud.request.SensorAutomationUpdateRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.SensorAutomationBasicResponse;
import com.myproject.cloud.response.SensorAutomationDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/censorAutomation")
@RequiredArgsConstructor
public class SensorAutomationController {
    private final SensorAutomationService sensorAutomationService;

    @GetMapping
    public ResponseEntity<BaseResponse> getAllCensorAutomation() {

        List<SensorAutomationModel> sensorAutomationModelList = sensorAutomationService.getAll();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("get all sensor automation success.");
        SensorAutomationDataResponse sensorAutomationDataResponse = new SensorAutomationDataResponse();
        sensorAutomationDataResponse.setSensorAutomationModelList(sensorAutomationModelList);
        baseResponse.setData(sensorAutomationDataResponse);
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createSensorAutomation(@RequestBody SensorAutomationCreateRequest sensorAutomationCreateRequest) throws URISyntaxException {
//        sensorDataService.validateSensorRequest(censorRequest);
        SensorAutomationModel sensorAutomationModel = new SensorAutomationModel();
        sensorAutomationModel.setSensorId("SENSOR_" + System.currentTimeMillis());
        sensorAutomationModel.setMinHumidity(sensorAutomationCreateRequest.getMinHumidity());
        sensorAutomationModel.setMaxHumidity(sensorAutomationCreateRequest.getMaxHumidity());
        sensorAutomationModel.setMinPeriod(sensorAutomationCreateRequest.getMinPeriod());
        sensorAutomationModel.setMaxPeriod(sensorAutomationCreateRequest.getMaxPeriod());
        sensorAutomationModel.setAutomationEnabled(sensorAutomationCreateRequest.getAutomationEnabled());
        sensorAutomationModel.setApplied(Boolean.FALSE);
        sensorAutomationService.create(sensorAutomationModel);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("sensor automation create success.");
        SensorAutomationBasicResponse dataResponse = new SensorAutomationBasicResponse();
        dataResponse.setSensorId(sensorAutomationModel.getSensorId());
        dataResponse.setMinHumidity(sensorAutomationModel.getMinHumidity());
        dataResponse.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        dataResponse.setMinPeriod(sensorAutomationModel.getMinPeriod());
        dataResponse.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        dataResponse.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        dataResponse.setApplied(Boolean.FALSE);
        baseResponse.setData(dataResponse);
        return ResponseEntity.created(new URI("/censorAutomation/" + sensorAutomationModel.getSensorId())).body(baseResponse);
    }

    @PutMapping("/{sensorId}")
    public ResponseEntity<BaseResponse> updateSensorAutomation(@RequestBody SensorAutomationUpdateRequest sensorAutomationUpdateRequest, @PathVariable("sensorId") String sensorId) throws URISyntaxException {
//        sensorDataService.validateSensorRequest(censorRequest);
        SensorAutomationModel sensorAutomationModel = new SensorAutomationModel();
        sensorAutomationModel.setSensorId(sensorId);
        sensorAutomationModel.setMinHumidity(sensorAutomationUpdateRequest.getMinHumidity());
        sensorAutomationModel.setMaxHumidity(sensorAutomationUpdateRequest.getMaxHumidity());
        sensorAutomationModel.setMinPeriod(sensorAutomationUpdateRequest.getMinPeriod());
        sensorAutomationModel.setMaxPeriod(sensorAutomationUpdateRequest.getMaxPeriod());
        sensorAutomationModel.setAutomationEnabled(sensorAutomationUpdateRequest.getAutomationEnabled());
        sensorAutomationModel.setApplied(Boolean.FALSE);
        sensorAutomationService.update(sensorAutomationModel);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("sensor automation update success.");
        SensorAutomationBasicResponse dataResponse = new SensorAutomationBasicResponse();
        dataResponse.setSensorId(sensorAutomationModel.getSensorId());
        dataResponse.setMinHumidity(sensorAutomationModel.getMinHumidity());
        dataResponse.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        dataResponse.setMinPeriod(sensorAutomationModel.getMinPeriod());
        dataResponse.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        dataResponse.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        dataResponse.setApplied(Boolean.FALSE);
        baseResponse.setData(dataResponse);
        return ResponseEntity.ok(baseResponse);
    }
}
