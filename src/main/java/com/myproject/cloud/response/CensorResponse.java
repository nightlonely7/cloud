package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.cloud.domain.model.SensorDataModel;
import lombok.Data;

import java.util.List;

@Data
public class CensorResponse implements DataResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idCensor;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SensorDataModel> listCensor;

    public CensorResponse of(String idCensor) {
        this.idCensor = idCensor;
        return this;
    }

}
