package com.zq.designdemo.proxy.ownwrite_proxy;

import java.lang.reflect.Method;

public interface GPInvokationHandler {

     Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
