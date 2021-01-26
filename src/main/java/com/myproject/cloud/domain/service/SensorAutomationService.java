package com.myproject.cloud.domain.service;

import com.myproject.cloud.domain.model.SensorAutomationModel;

import java.util.List;

public interface SensorAutomationService {

    SensorAutomationModel create(SensorAutomationModel sensorAutomationModel);
    SensorAutomationModel update(SensorAutomationModel sensorAutomationModel);
    List<SensorAutomationModel> getAll();
}
