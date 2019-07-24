package com.zq.designdemo.ownwrite_proxy;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//实现ClassLoader是jdk里面的一个标准
//作用：代码重新生成、编译、重新load到JVM中
public class GPClassLoader extends ClassLoader {
    private File file;

    public GPClassLoader() {
        String basePath = GPClassLoader.class.getResource("").getPath();
        this.file = new File(basePath);
    }

    //mac idea重写方法的快捷键 ctrl+o
    //如果不重写这个方法，就这用到了jdk的原生方法，重写此方法可以做到全都自己实现，不用jdk
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (this.file != null) {
            File classFile = new File(file, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                try {
                    in = new FileInputStream(classFile);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];//缓冲区
                    int len;
                    while ((len = in.read(bytes)) != -1) {
                        byteArrayOutputStream.write(bytes, 0, len);
                    }
                     return defineClass(className, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != in) {
                        try {
                            in.close();//一定要记住关流
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
