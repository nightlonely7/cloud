package com.myproject.cloud.domain.service;

import com.myproject.cloud.domain.model.SensorDataModel;
import com.myproject.cloud.request.CensorRequest;

import java.util.List;

public interface SensorDataService {

    void validateSensorRequest(CensorRequest censorRequest);
    SensorDataModel convertSensorRequest(CensorRequest censorRequest);
    SensorDataModel saveSensorData(SensorDataModel sensorDataModel);

    List<SensorDataModel> getAllSensorData();

}
