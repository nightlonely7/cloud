package com.myproject.cloud.domain.model;

import com.myproject.cloud.domain.entity.SensorDataEntity;
import com.myproject.cloud.request.CensorRequest;
import lombok.Data;

@Data
public class SensorDataModel {

    private String censorId;
    private String censorValue;
    private long measureTime;

    public SensorDataModel of(CensorRequest censorRequest) {
        this.censorId = censorRequest.getCensorId();
        this.censorValue = censorRequest.getCensorValue();
        this.measureTime = censorRequest.getMeasureTime();
        return this;
    }

    public SensorDataModel of(SensorDataEntity sensorDataEntity) {
        this.censorId = sensorDataEntity.getSensorId();
        this.censorValue = sensorDataEntity.getSensorValue();
        this.measureTime = sensorDataEntity.getMeasureTime();
        return this;
    }
}
