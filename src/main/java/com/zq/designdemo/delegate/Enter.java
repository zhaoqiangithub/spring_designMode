package com.zq.designdemo.delegate;

public class Enter {

    //什么是委派模式 关心结果
    /*
    1、委托人 持有受托人的引用，要不然怎么找得到受托人
    2、关心结果

    受托人 委托人
    项目经历（委托人）  安排任务
    员工（受托人）      执行
     */


    public static void main(String[] args) {
        //看上去是项目经历干活
        //其实是 项目经历委派给员工去具体实现了

        Dispatcher manage = new Dispatcher(new EmployeeA());
        manage.doing();

        //IOC中有一个Register的东西 告诉我们容器这个类被初始化的过程中需要做很多不同的逻辑处理，需要实现多个任务执行者，分别实现各自的功能
        //1、对用户而言只有一个入口  2、对用户隐藏实现  2、对用户来说可以通过一个执行者执行不听你的业务实现
    }


}
