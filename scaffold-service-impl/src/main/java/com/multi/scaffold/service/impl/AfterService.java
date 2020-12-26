package com.multi.scaffold.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author David Chan
 * @date 2020-12-26
 */
@Slf4j
@Service
public class AfterService {

    @Async
    public void sync(String id, String name) {
        log.info("nameId:{}", id);
        log.info("name:{}", name);
    }
}
