package com.myproject.cloud.controller;

import com.myproject.cloud.domain.model.CensorModel;
import com.myproject.cloud.domain.service.CloudService;
import com.myproject.cloud.request.CensorRequest;
import com.myproject.cloud.response.BaseResponse;
import com.myproject.cloud.response.CensorResponse;
import com.myproject.cloud.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cloud/v1")
@RequiredArgsConstructor
public class CloudController {

    private final CloudService cloudService;

    @PostMapping(value = "/censor")
    public ResponseEntity<BaseResponse> censor(@RequestBody CensorRequest censorRequest) {
        cloudService.validateCensorRequest(censorRequest);
        CensorModel censorModel = cloudService.convertCensorRequest(censorRequest);
        cloudService.saveCensor(censorModel);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("censor create success.");
        DataResponse dataResponse = new CensorResponse().of(censorModel.getCensorId());
        baseResponse.setData(dataResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(baseResponse);
    }

    @GetMapping(value = "/censor")
    public ResponseEntity<BaseResponse> censor(@PageableDefault(size = 1) Pageable pageable) {

        CensorModel censorModel = new CensorModel();
        censorModel.setCensorEntities(cloudService.getAllCensor(pageable));
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("censor create success.");
        CensorResponse dataResponse = new CensorResponse();
        dataResponse.setListCensor(censorModel.getCensorEntities());
        baseResponse.setData(dataResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(baseResponse);
    }
}
