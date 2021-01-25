package com.myproject.cloud.domain.service;

import com.myproject.cloud.domain.entity.CensorEntity;
import com.myproject.cloud.domain.model.CensorModel;
import com.myproject.cloud.request.CensorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CloudService {

    void validateCensorRequest(CensorRequest censorRequest);
    CensorModel convertCensorRequest(CensorRequest censorRequest);
    CensorModel saveCensor(CensorModel censorModel);

    Page<CensorEntity> getAllCensor(Pageable pageable);

}
