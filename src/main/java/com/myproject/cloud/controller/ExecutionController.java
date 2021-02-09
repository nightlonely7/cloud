package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.ExecutionModel;
import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.request.ExecutionCreateRequest;
import com.myproject.cloud.request.ExecutionUpdateRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.ExecutionDataResponse;
import com.myproject.cloud.response.ExecutionGetDataResponse;
import com.myproject.cloud.service.ExecutionService;
import com.myproject.cloud.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/execution")
@RequiredArgsConstructor
public class ExecutionController {

    private final ExecutionService executionService;

    @PostMapping
    public ResponseEntity<BaseResponse> createExecution(@RequestBody ExecutionCreateRequest executionCreateRequest) {

        System.out.println("execution created" + LocalDateTime.now());
        ExecutionModel executionModel = new ExecutionModel();
        executionModel.setExecutionId("EXECUTION_" + System.currentTimeMillis());
        executionModel.setSensorId(executionCreateRequest.getSensorId());
        executionModel.setCurrentHumidity(executionCreateRequest.getCurrentHumidity());
        executionModel.setTargetHumidity(executionCreateRequest.getTargetHumidity());
        executionModel.setRequestTime(executionCreateRequest.getRequestTime());
        executionModel.setExecuted(Boolean.FALSE);
        executionService.create(executionModel);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("execution created success.");
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{executionId}")
    public ResponseEntity<BaseResponse> updateExecution(@RequestBody ExecutionUpdateRequest executionCreateRequest,
                                                        @PathVariable("executionId") String executionId) {

        ExecutionModel executionModel = new ExecutionModel();
        executionModel.setExecutionId(executionId);
        executionModel.setExecutionTime(executionCreateRequest.getExecutionTime());
        executionModel.setExecuted(executionCreateRequest.getExecuted());
        executionService.update(executionModel);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("execution updated success.");
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllExecution() {
        List<ExecutionModel> executionModelList = executionService.findAllExecution();
        ExecutionGetDataResponse executionGetDataResponse = new ExecutionGetDataResponse();
        executionGetDataResponse.setCode(0);
        executionGetDataResponse.setMessage("execution get success");
        List<ExecutionDataResponse> executionDataResponseList = executionModelList.stream().map(executionModel -> {
            ExecutionDataResponse executionDataResponse = new ExecutionDataResponse();
            executionDataResponse.setExecutionId(executionModel.getExecutionId());
            executionDataResponse.setSensorId(executionModel.getSensorId());
            executionDataResponse.setCurrentHumidity(executionModel.getCurrentHumidity());
            executionDataResponse.setTargetHumidity(executionModel.getTargetHumidity());
            executionDataResponse.setExecuted(executionModel.getExecuted());
            executionDataResponse.setExecutionTime(executionModel.getExecutionTime());
            executionDataResponse.setRequestTime(executionModel.getRequestTime());
            return executionDataResponse;
        }).collect(Collectors.toList());

        executionGetDataResponse.setData(executionDataResponseList);
        return ResponseEntity.ok(executionGetDataResponse);
    }

}
