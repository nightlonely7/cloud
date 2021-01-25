package com.myproject.cloud.domain.model;

import com.myproject.cloud.domain.entity.CensorEntity;
import com.myproject.cloud.request.CensorRequest;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class CensorModel {
    private String censorId;
    private String censorValue;
    private long measureTime;
    private String userId;
    private Page<CensorEntity> censorEntities;

    public CensorModel of(CensorRequest censorRequest) {
        censorId = censorRequest.getCensorId();
        censorValue = censorRequest.getCensorValue();
        measureTime = censorRequest.getMeasureTime();
        userId = censorRequest.getUserId();
        return this;
    }
}
