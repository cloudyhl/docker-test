package com.test.docker.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

/**
 * @author yhl
 * @date 2020/6/16
 */
public class ClassByPath extends ClassLoader {

    public Class load(String name) throws Exception { //name为字节码文件的"位置+文件名"
        //利用IO把字节码数据加载到一个byte[] b
        FileInputStream fin = new FileInputStream(name);
        byte[] buf = new byte[512];
        int len;
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        while ((len = fin.read(buf)) != -1) {
            baout.write(buf, 0, len);
        }
        baout.close();//把缓存中的数据全部刷到baout中
        byte[] b = baout.toByteArray();
        //技术入口，调用父类ClassLoader中的defineClass()方法生成c对象
        return super.defineClass(null, b, 0, b.length);
    }

    public Set<Class> loadByPath(String pathName,Set<Class> classes) throws Exception {
        File file = new File(pathName);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileChild : files) {
                String filePath = pathName.concat("\\").concat(fileChild.getName());
                if (fileChild.isDirectory()){
                    this.loadByPath(filePath, classes);
                } else {
                    classes.add(this.load(filePath));
                }
            }
        }
        return classes;
    }
}
