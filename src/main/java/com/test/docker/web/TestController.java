package com.test.docker.web;

import com.test.docker.service.ServiceInterface;
import com.test.docker.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yhl
 * @date 2020/4/27
 */
@RequestMapping
@RestController
public class TestController {


    @Resource
    private ServiceInterface testService;

    @GetMapping("hello")
    public String hello(){
        return testService.hello();
    }
}
