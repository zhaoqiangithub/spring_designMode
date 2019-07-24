package com.zq.designdemo.daili;


import com.zq.designdemo.proxy.MeiPo;
import com.zq.designdemo.proxy.Person;
import com.zq.designdemo.proxy.Zhangsan;

public class Enter {
    public static void main(String[] args) {
        //1、这个是不用代理前，只能自己去寻找对象
//        new Zhangsan().findTrueLove();

        //2、自从有了媒婆代理(jdk动态代理)
        try {
            Person person = (Person)new MeiPo().getInstance(new Zhangsan());
            System.out.println("代理对象："+person.getClass());
            // TODO: 2019/7/19 问题。上面如果时打印person的话， person为空，跟invoke的返回值保持一致， 但是如果不打印 或者打印person.getClass()的话，结果正常符合预期
            person.findTrueLove();

//            2、简单写法
//            Zhangsan zhangsan = new Zhangsan();
//            System.out.println("zhangsan :"+zhangsan.getClass());
////            代理张三的方法
//            Person proxyInstance = (Person)Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(), zhangsan.getClass().getInterfaces(),
//                    new InvocationHandler() {//第三个参数，使用
//                        @Override
//                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                            System.out.println("我是代理");
//                            Object invoke = method.invoke(zhangsan, args);
//                            return invoke;
//                        }
//                    });
//            System.out.println("proxy:"+proxyInstance.getClass());
//            proxyInstance.findTrueLove();


            //获取到给被代理对象生成的字节码 $Proxy_own代理对象的类名，F:/class/$Proxy_own.class代理对象写到本地的文件名，和类名一致
//            byte[] proxy = ProxyGenerator.generateProxyClass("$Proxy_own", new Class[]{person.getClass()});
//            FileOutputStream fileOutputStream = new FileOutputStream("F:/class/$Proxy_own.class");
//            fileOutputStream.write(proxy);
//            fileOutputStream.close();
            /* 生成的代理方法
             public final void findTrueLove()
                throws
              {
                try
                {
                  this.h.invoke(this, m4, null);   //this是代理对象$Proxy_own，它继承Proxy，this.h是Proxy中的全局变量InvocationHandler类型，保存的是代理对象MeiPo的引用。this.h可以调用MeiPo重写的invoke方法
                  return;
                }
                catch (RuntimeException localRuntimeException)
                {
                  throw localRuntimeException;
                }
                catch (Throwable localThrowable)
                {
                  throw new UndeclaredThrowableException(localThrowable);
                }
              }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
