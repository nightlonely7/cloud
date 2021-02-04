package com.myproject.cloud.service;

import com.myproject.cloud.domain.model.ExecutionModel;

import java.util.List;

public interface ExecutionService {
    ExecutionModel create(ExecutionModel executionModel);
    ExecutionModel update(ExecutionModel executionModel);
    List<ExecutionModel> findAllExecution();
}
