package com.myproject.cloud.service;

import com.myproject.cloud.domain.model.SensorModel;

import java.util.List;

public interface SensorService {
    List<SensorModel> getAllSensor();
    SensorModel createSensor(SensorModel sensorModel);
    SensorModel updateSensor(SensorModel sensorModel);
}
