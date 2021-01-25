package com.myproject.cloud.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.cloud.domain.entity.CensorEntity;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class CensorResponse implements DataResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idCensor;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Page<CensorEntity> listCensor;

    public CensorResponse of(String idCensor) {
        this.idCensor = idCensor;
        return this;
    }

}
