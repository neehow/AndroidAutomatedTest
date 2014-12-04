package com.liepin.driver.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LocatingElementHandler implements InvocationHandler {

    private Object object;
    
    public LocatingElementHandler(Object object) {
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();  
        method.invoke(object, args);
//        Object result = method.invoke(dele, args);  
        return null;
    }
    
    private void doBefore() {  
        System.out.println("before....");  
    } 
}
