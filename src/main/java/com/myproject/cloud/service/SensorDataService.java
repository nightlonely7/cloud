package com.myproject.cloud.service;

import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.request.SensorDataCreateRequest;

import java.util.List;

public interface SensorDataService {

    void validateSensorRequest(SensorDataCreateRequest sensorDataCreateRequest);
    SensorDataModel convertSensorRequest(SensorDataCreateRequest sensorDataCreateRequest);
    SensorDataModel saveSensorData(SensorDataModel sensorDataModel);

    List<SensorDataModel> getAllSensorData();
    List<SensorDataModel> getAllSensorDataBySensorId(String sensorId);

}
