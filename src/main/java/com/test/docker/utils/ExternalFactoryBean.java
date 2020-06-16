package com.test.docker.utils;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author yhl
 * @date 2020/6/16
 */
@Data
public class ExternalFactoryBean implements FactoryBean {

    private Class clazz;


    @Override
    public Object getObject() throws Exception {
        return clazz.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
