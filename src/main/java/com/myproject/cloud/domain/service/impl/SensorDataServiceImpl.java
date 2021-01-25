package com.myproject.cloud.domain.service.impl;

import com.myproject.cloud.domain.entity.SensorDataEntity;
import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.domain.repository.SensorDataRepository;
import com.myproject.cloud.domain.service.SensorDataService;
import com.myproject.cloud.request.CensorRequest;
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
    public void validateSensorRequest(CensorRequest censorRequest) {
        return;
    }

    @Override
    public SensorDataModel convertSensorRequest(CensorRequest censorRequest) {
        return new SensorDataModel().of(censorRequest);
    }

    @Override
    public SensorDataModel saveSensorData(SensorDataModel sensorDataModel) {
        sensorDataRepository.save(new SensorDataEntity().ofCreated(sensorDataModel));
        log.info("censor id {}", sensorDataModel.getCensorId());
        return sensorDataModel;
    }

    @Override
    public List<SensorDataModel> getAllSensorData() {
        return sensorDataRepository.findAll().stream().map(censorEntity -> new SensorDataModel().of(censorEntity)).collect(Collectors.toList());
    }
}
