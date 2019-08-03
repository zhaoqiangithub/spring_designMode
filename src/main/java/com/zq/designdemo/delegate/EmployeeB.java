package com.zq.designdemo.delegate;

public class EmployeeB implements IDelegate{
    @Override
    public void doing() {
        System.out.println("员工B工作");
    }
}
