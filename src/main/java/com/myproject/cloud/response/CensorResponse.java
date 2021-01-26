package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.cloud.domain.model.SensorDataModel;
import lombok.Data;

import java.util.List;

@Data
public class CensorResponse implements DataResponse {
    private List<SensorDataModel> listCensor;
}
