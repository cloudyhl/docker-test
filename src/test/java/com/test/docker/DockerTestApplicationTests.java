package com.test.docker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DockerTestApplicationTests {

    public DockerTestApplicationTests(){}

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {

        System.out.println(applicationContext.getBean(TestService.class));
        System.out.println(applicationContext);
    }

}
