package com.myproject.cloud.domain.service.impl;

import com.myproject.cloud.domain.entity.CensorEntity;
import com.myproject.cloud.domain.model.CensorModel;
import com.myproject.cloud.domain.repository.CensorRepository;
import com.myproject.cloud.domain.service.CloudService;
import com.myproject.cloud.request.CensorRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CloudServiceImpl implements CloudService {

    private final CensorRepository censorRepository;

    @Override
    public void validateCensorRequest(CensorRequest censorRequest) {
        return;
    }

    @Override
    public CensorModel convertCensorRequest(CensorRequest censorRequest) {
        return new CensorModel().of(censorRequest);
    }

    @Override
    public CensorModel saveCensor(CensorModel censorModel) {
        censorRepository.save(new CensorEntity().ofCreated(censorModel));
        log.info("censor id {}", censorModel.getCensorId());
        return censorModel;
    }

    @Override
    public Page<CensorEntity> getAllCensor(Pageable pageable) {
        return censorRepository.findAll(pageable);
    }
}
