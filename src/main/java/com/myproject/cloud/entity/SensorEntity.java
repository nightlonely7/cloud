package com.myproject.cloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensor_data")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "sensor_name")
    private String sensorName;

    @Column(name = "note")
    private String note;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "last_modified_time")
    private LocalDateTime lastModifiedTime;

}
