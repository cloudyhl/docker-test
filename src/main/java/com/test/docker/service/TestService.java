package com.test.docker.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yhl
 * @date 2020/6/16
 */
@Service
public class TestService implements ServiceInterface{

    @Resource
    private ServiceTwo serviceTwo;

    @Override
    public String hello(){
        serviceTwo.sout();
        return "hellosdsasdsa";
    }
}
