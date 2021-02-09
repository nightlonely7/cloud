package com.myproject.cloud.service.impl;

import com.myproject.cloud.domain.model.ExecutionModel;
import com.myproject.cloud.entity.ExecutionEntity;
import com.myproject.cloud.repository.ExecutionRepository;
import com.myproject.cloud.service.ExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExecutionServiceImpl implements ExecutionService {

    private final ExecutionRepository executionRepository;

    @Override
    public ExecutionModel create(ExecutionModel executionModel) {
        ExecutionEntity executionEntity = new ExecutionEntity();
        executionEntity.setExecutionId(executionModel.getExecutionId());
        executionEntity.setSensorId(executionModel.getSensorId());
        executionEntity.setCurrentHumidity(executionModel.getCurrentHumidity());
        executionEntity.setTargetHumidity(executionModel.getTargetHumidity());
        executionEntity.setRequestTime(executionModel.getRequestTime());
        executionEntity.setExecuted(executionModel.getExecuted());
        executionEntity.setCreatedTime(LocalDateTime.now());
        executionEntity.setLastModifiedTime(LocalDateTime.now());
        executionRepository.save(executionEntity);
        return executionModel;
    }

    @Override
    public ExecutionModel update(ExecutionModel executionModel) {
        ExecutionEntity executionEntity = executionRepository.findByExecutionId(executionModel.getExecutionId())
                .orElseThrow(() -> new IllegalArgumentException("executionId '" + executionModel.getExecutionId() + "' not found."));
        executionEntity.setExecutionTime(executionModel.getExecutionTime());
        executionEntity.setExecuted(executionModel.getExecuted());
        executionEntity.setLastModifiedTime(LocalDateTime.now());
        executionRepository.save(executionEntity);
        return executionModel;
    }

    @Override
    public List<ExecutionModel> findAllExecution() {
        return executionRepository.findAllByOrderByCreatedTimeDesc().stream().map(executionEntity -> {
            ExecutionModel executionModel = new ExecutionModel();
            executionModel.setExecutionId(executionEntity.getExecutionId());
            executionModel.setSensorId(executionEntity.getSensorId());
            executionModel.setCurrentHumidity(executionEntity.getCurrentHumidity());
            executionModel.setTargetHumidity(executionEntity.getTargetHumidity());
            executionModel.setExecuted(executionEntity.getExecuted());
            executionModel.setExecutionTime(executionEntity.getExecutionTime());
            executionModel.setRequestTime(executionEntity.getRequestTime());
            return executionModel;
        }).collect(Collectors.toList());
    }
}
