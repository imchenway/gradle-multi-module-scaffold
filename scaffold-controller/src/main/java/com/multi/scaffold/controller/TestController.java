package com.multi.scaffold.controller;

import com.multi.scaffold.model.TestDo;
import com.multi.scaffold.service.api.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Chan
 * @date 2020-12-13
 */
@RestController
@EnableAsync
public class TestController {
    @Autowired
    private ITest iTest;

    @GetMapping("hello")
    public String getName(@RequestParam(required = false) String name) {
        return iTest.hello(name);
    }

    @PostMapping("hello")
    public String updateName(@RequestBody TestDo testDo) {
        return iTest.updateName(testDo);
    }
}
