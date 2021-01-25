package com.myproject.cloud.domain.entity;

import com.myproject.cloud.domain.model.CensorModel;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Entity
@Table(name = "censor_info")
public class CensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "censor_id")
    private String censorId;

    @Column(name = "censor_value")
    private String censorValue;

    @Column(name = "measure_time")
    private LocalDateTime measureTime;

    public CensorEntity ofCreated(CensorModel censorModel){

        censorId = censorModel.getCensorId();
        censorValue = censorModel.getCensorValue();
        measureTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(censorModel.getMeasureTime()), ZoneId.systemDefault());
        createdUser = censorModel.getUserId();
        createdTime = LocalDateTime.now();
        return this;
    }

}
