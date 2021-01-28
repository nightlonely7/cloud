package com.myproject.cloud.service;

import com.myproject.cloud.domain.model.SensorAutomationModel;

import java.util.List;

public interface SensorAutomationService {

    SensorAutomationModel findBySensorAutomationId(String sensorAutomationId);
    SensorAutomationModel create(SensorAutomationModel sensorAutomationModel);
    SensorAutomationModel update(SensorAutomationModel sensorAutomationModel);
    List<SensorAutomationModel> getAll();
}
