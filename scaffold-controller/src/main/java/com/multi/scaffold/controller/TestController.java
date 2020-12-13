package com.multi.scaffold.controller;

import com.multi.scaffold.service.api.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Chan
 * @date 2020-12-13
 */
@RestController
public class TestController {
    @Autowired
    private ITest iTest;

    @GetMapping("hello")
    public String test() {
        return iTest.hello();
    }
}
