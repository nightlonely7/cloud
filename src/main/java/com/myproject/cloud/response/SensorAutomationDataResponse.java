package com.myproject.cloud.response;

import com.myproject.cloud.domain.model.SensorAutomationModel;
import lombok.Data;

import java.util.List;

@Data
public class SensorAutomationDataResponse implements DataResponse {
    private List<SensorAutomationModel> sensorAutomationModelList;
}
