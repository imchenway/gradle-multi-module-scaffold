package com.multi.scaffold.service.impl;

import com.multi.scaffold.model.TestDo;
import com.multi.scaffold.persist.TestMapper;
import com.multi.scaffold.service.api.ITest;
import com.muti.scaffold.MethodPointCut;
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
    @MethodPointCut(businessName = "#name")
    public String hello(String name) {
        return testMapper.getName();
    }

    @Override
    @MethodPointCut(businessId = "#testDo.id", businessName = "#testDo.name")
    public String updateName(TestDo testDo) {
        return testMapper.updateName(testDo);
    }
}
