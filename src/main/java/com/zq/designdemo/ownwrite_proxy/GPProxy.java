package com.zq.designdemo.ownwrite_proxy;


import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

//生成代理对象的代码
public class GPProxy {

    private static String ln = "/r/n";

    //ClassLoader GPInvokationHandler也是自己定义
    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvokationHandler h)
            throws IllegalArgumentException{



        //1、生成源代码
        String proSrc = generateSrc(interfaces[0]);

        //2、将生成的源代码输出到磁盘保存为java文件
        String path = GPProxy.class.getResource("").getPath();
        File file = new File(path + "$Proxy_own.java");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(proSrc);
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        //3、编译源代码，生成class文件

        //4、将class文件中的内容动态加载到jvm中

        //5、返回被代理后的代理对象
        return null;
    }

    private  static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;" + ln);
        src.append("import java.lang.reflect.Method" + ln);
        src.append("public final class $Proxy_own implements " + interfaces.getName() +"{" + ln);

        src.append("GPInvokationHandler h;" + ln);
        src.append("public $Proxy_own(GPInvokationHandler h){" + ln);//构造方法
        src.append("this.h = h;" + ln);
        for (Method m:interfaces.getMethods()) {
            src.append("public "+ m.getReturnType()+" "+m.getName()+"() thorws Throwable {");
            src.append("Method m=" + interfaces.getName() + ".class.getMethod(" + m.getName() +",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);"+ln);
            src.append("}"+ln);
        }
        src.append("}" + ln);
        return src.toString();
    }
}
