package com.test.docker.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yhl
 * @date 2019/5/30
 */
@Component
public class BaseSpringBeanHandler implements BeanDefinitionRegistryPostProcessor {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry){

        //设置beanDefinition中的属性值,例如clazz  设置为Dynamic.class
        ClassByPath classByPath = new ClassByPath();
        Set<Class> classes = new HashSet<>();
        try {
            classByPath.loadByPath("E:\\project\\classes", classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Class aClass : classes) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ExternalFactoryBean.class);
            GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionBuilder.getRawBeanDefinition();
            definition.getPropertyValues().add("clazz", aClass);
            //definition.setBeanClass(ProxyFactoryBean.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            definition.setScope(BeanDefinition.SCOPE_SINGLETON);
            registry.registerBeanDefinition(CharacterUtils.toLowerCaseFirstOne(aClass.getSimpleName()),definition);
        }
        System.out.println(applicationContext);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
