package com.myproject.cloud.domain.model;

import com.myproject.cloud.entity.SensorDataEntity;
import com.myproject.cloud.request.SensorDataCreateRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorDataModel {

    private String sensorId;
    private String sensorValue;
    private LocalDateTime measureTime;

    public SensorDataModel of(SensorDataCreateRequest sensorDataCreateRequest) {
        this.sensorId = sensorDataCreateRequest.getSensorId();
        this.sensorValue = sensorDataCreateRequest.getSensorValue();
        this.measureTime = sensorDataCreateRequest.getMeasureTime();
        return this;
    }

    public SensorDataModel of(SensorDataEntity sensorDataEntity) {
        this.sensorId = sensorDataEntity.getSensorId();
        this.sensorValue = sensorDataEntity.getSensorValue();
        this.measureTime = sensorDataEntity.getMeasureTime();
        return this;
    }
}
