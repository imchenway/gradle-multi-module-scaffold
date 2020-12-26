package com.multi.scaffold.persist;

import com.multi.scaffold.model.TestDo;
import org.springframework.stereotype.Repository;

/**
 * @author David Chan
 * @date 2020-12-13
 */
@Repository
public class TestMapper {
    public String getName() {
        return "hello";
    }

    public String updateName(TestDo testDo) {
        return testDo.getName();
    }
}