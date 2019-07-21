package com.zq.designdemo.ownwrite_proxy;


//生成代理对象的代码
public class GPProxy {

    //ClassLoader GPInvokationHandler也是自己定义
    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvokationHandler h)
            throws IllegalArgumentException{

        //1、生成源代码
        String proSrc = generateSrc(interfaces);

        //2、将生成的源代码输出到磁盘保存为java文件

        //3、编译源代码，生成class文件

        //4、将class文件中的内容动态加载到jvm中

        //5、返回被代理后的代理对象
        return null;
    }

    private  static String generateSrc(Class<?>[] interfaces){
        StringBuffer src = ""
        return "";
    }
}
