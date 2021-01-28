package com.myproject.cloud.service.impl;

import com.myproject.cloud.entity.SensorAutomationEntity;
import com.myproject.cloud.domain.model.SensorAutomationModel;
import com.myproject.cloud.repository.SensorAutomationRepository;
import com.myproject.cloud.service.SensorAutomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorAutomationServiceImpl implements SensorAutomationService {

    private final SensorAutomationRepository sensorAutomationRepository;

    @Override
    public SensorAutomationModel findBySensorAutomationId(String sensorAutomationId) {
        SensorAutomationEntity sensorAutomationEntity = sensorAutomationRepository
                .findBySensorAutomationId(sensorAutomationId)
                .orElseThrow(() -> new IllegalArgumentException("sensorAutomationId '" + sensorAutomationId + "' not found."));
        SensorAutomationModel sensorAutomationModel = new SensorAutomationModel();
        sensorAutomationModel.setSensorId(sensorAutomationEntity.getSensorId());
        sensorAutomationModel.setSensorAutomationId(sensorAutomationEntity.getSensorAutomationId());
        sensorAutomationModel.setSensorAutomationName(sensorAutomationEntity.getSensorAutomationName());
        sensorAutomationModel.setMinHumidity(sensorAutomationEntity.getMinHumidity());
        sensorAutomationModel.setMaxHumidity(sensorAutomationEntity.getMaxHumidity());
        sensorAutomationModel.setMinPeriod(sensorAutomationEntity.getMinPeriod());
        sensorAutomationModel.setMaxPeriod(sensorAutomationEntity.getMaxPeriod());
        sensorAutomationModel.setAutomationEnabled(sensorAutomationEntity.getAutomationEnabled());
        return sensorAutomationModel;
    }

    @Override
    public SensorAutomationModel create(SensorAutomationModel sensorAutomationModel) {

        SensorAutomationEntity sensorAutomationEntity = new SensorAutomationEntity();
        sensorAutomationEntity.setSensorId(sensorAutomationModel.getSensorId());
        sensorAutomationEntity.setSensorAutomationId(sensorAutomationModel.getSensorAutomationId());
        sensorAutomationEntity.setSensorAutomationName(sensorAutomationModel.getSensorAutomationName());
        sensorAutomationEntity.setMinHumidity(sensorAutomationModel.getMinHumidity());
        sensorAutomationEntity.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        sensorAutomationEntity.setMinPeriod(sensorAutomationModel.getMinPeriod());
        sensorAutomationEntity.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        sensorAutomationEntity.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        sensorAutomationEntity.setApplied(sensorAutomationModel.getApplied());
        sensorAutomationEntity.setCreatedTime(LocalDateTime.now());
        sensorAutomationEntity.setLastModifiedTime(LocalDateTime.now());
        sensorAutomationRepository.save(sensorAutomationEntity);

        return sensorAutomationModel;
    }

    @Override
    public SensorAutomationModel update(SensorAutomationModel sensorAutomationModel) {
        SensorAutomationEntity sensorAutomationEntity = sensorAutomationRepository
                .findBySensorAutomationId(sensorAutomationModel.getSensorAutomationId())
                .orElseThrow(() -> new IllegalArgumentException("sensorId '" + sensorAutomationModel.getSensorId() + "' not found."));
        sensorAutomationEntity.setMinHumidity(sensorAutomationModel.getMinHumidity());
        sensorAutomationEntity.setMaxHumidity(sensorAutomationModel.getMaxHumidity());
        sensorAutomationEntity.setMinPeriod(sensorAutomationModel.getMinPeriod());
        sensorAutomationEntity.setMaxPeriod(sensorAutomationModel.getMaxPeriod());
        sensorAutomationEntity.setAutomationEnabled(sensorAutomationModel.getAutomationEnabled());
        sensorAutomationEntity.setApplied(sensorAutomationModel.getApplied());
        sensorAutomationEntity.setCreatedTime(LocalDateTime.now());
        sensorAutomationEntity.setLastModifiedTime(LocalDateTime.now());
        sensorAutomationRepository.save(sensorAutomationEntity);
        return sensorAutomationModel;
    }

    @Override
    public List<SensorAutomationModel> getAll() {
        List<SensorAutomationModel> sensorAutomationModelList = new ArrayList<>();
        List<SensorAutomationEntity> sensorAutomationEntityList = sensorAutomationRepository.findAll();
        sensorAutomationEntityList.forEach(sensorAutomationEntity -> {
            SensorAutomationModel sensorAutomationModel = new SensorAutomationModel();
            sensorAutomationModel.setSensorId(sensorAutomationEntity.getSensorId());
            sensorAutomationModel.setSensorAutomationId(sensorAutomationEntity.getSensorAutomationId());
            sensorAutomationModel.setSensorAutomationName(sensorAutomationEntity.getSensorAutomationName());
            sensorAutomationModel.setMinHumidity(sensorAutomationEntity.getMinHumidity());
            sensorAutomationModel.setMaxHumidity(sensorAutomationEntity.getMaxHumidity());
            sensorAutomationModel.setMinPeriod(sensorAutomationEntity.getMinPeriod());
            sensorAutomationModel.setMaxPeriod(sensorAutomationEntity.getMaxPeriod());
            sensorAutomationModel.setAutomationEnabled(sensorAutomationEntity.getAutomationEnabled());
            sensorAutomationModel.setApplied(sensorAutomationEntity.getApplied());
            sensorAutomationModelList.add(sensorAutomationModel);
        });

        return sensorAutomationModelList;
    }
}
