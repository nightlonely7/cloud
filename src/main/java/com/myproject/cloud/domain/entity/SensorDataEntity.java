package com.myproject.cloud.domain.entity;

import com.myproject.cloud.domain.model.SensorDataModel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensor_data")
public class SensorDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "sensor_value")
    private String sensorValue;

    @Column(name = "measure_time")
    private Long measureTime;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    public SensorDataEntity ofCreated(SensorDataModel sensorDataModel) {

        this.sensorId = sensorDataModel.getCensorId();
        this.sensorValue = sensorDataModel.getCensorValue();
        this.measureTime = sensorDataModel.getMeasureTime();
        this.createdTime = LocalDateTime.now();
        return this;
    }

}
