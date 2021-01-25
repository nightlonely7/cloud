package com.myproject.cloud.domain.service.impl;

import com.myproject.cloud.domain.model.SensorModel;
import com.myproject.cloud.domain.repository.SensorRepository;
import com.myproject.cloud.domain.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public List<SensorModel> getAllSensor() {
        return sensorRepository.findAll().stream().map(
                sensorEntity -> {
                    SensorModel sensorModel = new SensorModel();
                    sensorModel.setSensorId(sensorEntity.getSensorId());
                    sensorModel.setSensorName(sensorEntity.getSensorName());
                    sensorModel.setNote(sensorEntity.getNote());
                    sensorModel.setUserId(sensorEntity.getUserId());
                    return sensorModel;
                }
        ).collect(Collectors.toList());
    }
}