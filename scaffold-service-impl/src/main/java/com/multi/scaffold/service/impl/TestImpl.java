package com.multi.scaffold.service.impl;

import com.multi.scaffold.persist.TestMapper;
import com.multi.scaffold.service.api.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author David Chan
 * @date 2020-12-13
 */
@Service
public class TestImpl implements ITest {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String hello() {
        return testMapper.getName();
    }
}
