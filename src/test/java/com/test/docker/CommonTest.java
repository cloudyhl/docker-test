package com.test.docker;

import com.test.docker.utils.ClassByDir;
import com.test.docker.utils.ClassByPath;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class CommonTest {

    @Test
    public void testLoadClass() throws Exception {
        Set<Class<?>> classes = ClassByDir.loadClasses("E:\\project\\classes");
        classes.forEach(clazz -> {
            System.out.println(clazz.getSimpleName());
        });
    }

    @Test
    public void testLoad() throws Exception {
        ClassByPath classByPath = new ClassByPath();
        //Class load = classByPath.load("E:\\project\\classes\\MemberAddVo.class");
        Set<Class> set = new HashSet<>();
        classByPath.loadByPath("E:\\project\\classes", set);
        for (Class aClass : set) {
            System.out.println(aClass.getSimpleName());
        }
    }
}
