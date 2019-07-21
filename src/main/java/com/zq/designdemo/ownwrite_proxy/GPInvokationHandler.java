package com.zq.designdemo.ownwrite_proxy;

import java.lang.reflect.Method;

public interface GPInvokationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
