package com.test.docker.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceTwoImpl implements ServiceTwo {
    @Override
    public String sout() {
        return "sout";
    }
}
