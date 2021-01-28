package com.myproject.cloud.service.impl;

import com.myproject.cloud.entity.SensorDataEntity;
import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.repository.SensorDataRepository;
import com.myproject.cloud.service.SensorDataService;
import com.myproject.cloud.request.SensorDataCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorDataServiceImpl implements SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    @Override
    public void validateSensorRequest(SensorDataCreateRequest sensorDataCreateRequest) {
        return;
    }

    @Override
    public SensorDataModel convertSensorRequest(SensorDataCreateRequest sensorDataCreateRequest) {
        return new SensorDataModel().of(sensorDataCreateRequest);
    }

    @Override
    public SensorDataModel saveSensorData(SensorDataModel sensorDataModel) {
        sensorDataRepository.save(new SensorDataEntity().ofCreated(sensorDataModel));
        log.info("censor id {}", sensorDataModel.getSensorId());
        return sensorDataModel;
    }

    @Override
    public List<SensorDataModel> getAllSensorData() {
        return sensorDataRepository.findAll().stream().map(sensorEntity -> new SensorDataModel().of(sensorEntity)).collect(Collectors.toList());
    }
}
