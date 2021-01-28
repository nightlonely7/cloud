package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.SensorAutomationModel;
import com.myproject.cloud.response.SensorAutomationCreateResponse;
import com.myproject.cloud.service.SensorAutomationService;
import com.myproject.cloud.request.SensorAutomationCreateRequest;
import com.myproject.cloud.request.SensorAutomationUpdateRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.SensorAutomationBasicResponse;
import com.myproject.cloud.response.SensorAutomationGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sensorAutomation")
@RequiredArgsConstructor
public class SensorAutomationController {
    private final SensorAutomationService sensorAutomationService;

    @GetMapping
    public ResponseEntity<BaseResponse> getAllCensorAutomation() {

        List<SensorAutomationModel> sensorAutomationModelList = sensorAutomationService.getAll();

        SensorAutomationGetAllResponse sensorAutomationGetAllResponse = new SensorAutomationGetAllResponse();
        sensorAutomationGetAllResponse.setCode(0);
        sensorAutomationGetAllResponse.setMessage("get all sensor automation success.");
        sensorAutomationGetAllResponse.setData(sensorAutomationModelList.stream().map(sensorAutomationModel -> {
            SensorAutomationBasicResponse sensorAutomationBasicResponse = new SensorAutomationBasicResponse();
            sensorAutomationBasicResponse.setSensorId(sensorAutomationModel.getSensorId());
            sensorAutomationBasicResponse.setSensorAutomationId(sensorAutomationModel.getSensorAutomationId());
            sensorAutomationBasicResponse.setSensorAutomationName(sensorAutomationModel.getSensorAutomationName());
            sensorAutomationBasicResponse.setMinHumidity(sensorAutomationModel.getMinHumidity());
            sensorAutomationBasicResponse.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
            sensorAutomationBasicResponse.setMinPeriod(sensorAutomationModel.getMinPeriod());
            sensorAutomationBasicResponse.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
            sensorAutomationBasicResponse.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
            sensorAutomationBasicResponse.setApplied(sensorAutomationModel.getApplied());
            return sensorAutomationBasicResponse;
        }).collect(Collectors.toList()));
        return ResponseEntity.ok(sensorAutomationGetAllResponse);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createSensorAutomation(@RequestBody SensorAutomationCreateRequest sensorAutomationCreateRequest) throws URISyntaxException {
//        sensorDataService.validateSensorRequest(censorRequest);
        SensorAutomationModel sensorAutomationModel = new SensorAutomationModel();
        sensorAutomationModel.setSensorId(sensorAutomationCreateRequest.getSensorId());
        sensorAutomationModel.setSensorAutomationId("SENSOR_" + System.currentTimeMillis());
        sensorAutomationModel.setSensorAutomationName(sensorAutomationCreateRequest.getSensorAutomationName());
        sensorAutomationModel.setMinHumidity(sensorAutomationCreateRequest.getMinHumidity());
        sensorAutomationModel.setMaxHumidity(sensorAutomationCreateRequest.getMaxHumidity());
        sensorAutomationModel.setMinPeriod(sensorAutomationCreateRequest.getMinPeriod());
        sensorAutomationModel.setMaxPeriod(sensorAutomationCreateRequest.getMaxPeriod());
        sensorAutomationModel.setAutomationEnabled(sensorAutomationCreateRequest.getAutomationEnabled());
        sensorAutomationModel.setApplied(sensorAutomationCreateRequest.getApplied());
        sensorAutomationService.create(sensorAutomationModel);

        SensorAutomationCreateResponse sensorAutomationCreateResponse = new SensorAutomationCreateResponse();
        sensorAutomationCreateResponse.setCode(0);
        sensorAutomationCreateResponse.setMessage("sensor automation create success.");
        SensorAutomationBasicResponse sensorAutomationBasicResponse = new SensorAutomationBasicResponse();
        sensorAutomationBasicResponse.setSensorId(sensorAutomationModel.getSensorId());
        sensorAutomationBasicResponse.setSensorAutomationId(sensorAutomationModel.getSensorAutomationId());
        sensorAutomationBasicResponse.setSensorAutomationName(sensorAutomationModel.getSensorAutomationName());
        sensorAutomationBasicResponse.setMinHumidity(sensorAutomationModel.getMinHumidity());
        sensorAutomationBasicResponse.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        sensorAutomationBasicResponse.setMinPeriod(sensorAutomationModel.getMinPeriod());
        sensorAutomationBasicResponse.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        sensorAutomationBasicResponse.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        sensorAutomationBasicResponse.setApplied(sensorAutomationModel.getApplied());
        sensorAutomationCreateResponse.setData(sensorAutomationBasicResponse);
        return ResponseEntity.created(new URI("/censorAutomation/" + sensorAutomationModel.getSensorId())).body(sensorAutomationCreateResponse);
    }

    @PutMapping("/{sensorAutomationId}")
    public ResponseEntity<BaseResponse> updateSensorAutomation(@RequestBody SensorAutomationUpdateRequest sensorAutomationUpdateRequest, @PathVariable("sensorAutomationId") String sensorAutomationId) throws URISyntaxException {
//        sensorDataService.validateSensorRequest(censorRequest);

        SensorAutomationModel sensorAutomationModel = sensorAutomationService.findBySensorAutomationId(sensorAutomationId);
        sensorAutomationModel.setMinHumidity(sensorAutomationUpdateRequest.getMinHumidity());
        sensorAutomationModel.setMaxHumidity(sensorAutomationUpdateRequest.getMaxHumidity());
        sensorAutomationModel.setMinPeriod(sensorAutomationUpdateRequest.getMinPeriod());
        sensorAutomationModel.setMaxPeriod(sensorAutomationUpdateRequest.getMaxPeriod());
        sensorAutomationModel.setAutomationEnabled(sensorAutomationUpdateRequest.getAutomationEnabled());
        sensorAutomationModel.setApplied(sensorAutomationUpdateRequest.getApplied());
        sensorAutomationService.update(sensorAutomationModel);

        SensorAutomationCreateResponse sensorAutomationCreateResponse = new SensorAutomationCreateResponse();
        sensorAutomationCreateResponse.setCode(0);
        sensorAutomationCreateResponse.setMessage("sensor automation update success.");
        SensorAutomationBasicResponse sensorAutomationBasicResponse = new SensorAutomationBasicResponse();
        sensorAutomationBasicResponse.setSensorId(sensorAutomationModel.getSensorId());
        sensorAutomationBasicResponse.setSensorAutomationId(sensorAutomationModel.getSensorAutomationId());
        sensorAutomationBasicResponse.setSensorAutomationName(sensorAutomationModel.getSensorAutomationName());
        sensorAutomationBasicResponse.setMinHumidity(sensorAutomationModel.getMinHumidity());
        sensorAutomationBasicResponse.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        sensorAutomationBasicResponse.setMinPeriod(sensorAutomationModel.getMinPeriod());
        sensorAutomationBasicResponse.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        sensorAutomationBasicResponse.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        sensorAutomationBasicResponse.setApplied(sensorAutomationModel.getApplied());
        sensorAutomationCreateResponse.setData(sensorAutomationBasicResponse);
        return ResponseEntity.ok(sensorAutomationCreateResponse);
    }
}
