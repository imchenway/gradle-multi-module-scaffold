package com.multi.scaffold.service.api;

import com.multi.scaffold.model.TestDo;

/**
 * @author David Chan
 * @date 2020-12-13
 */
public interface ITest {
    /**
     * test interface api
     *
     * @param name name
     * @return dao mock data
     * @author David Chan
     * @date 2020/12/13
     */
    String hello(String name);

    /**
     * test interface api
     *
     * @param testDo testDo
     * @return 修改后的name
     * @author David Chan
     * @date 2020/12/27
     */
    String updateName(TestDo testDo);
}
