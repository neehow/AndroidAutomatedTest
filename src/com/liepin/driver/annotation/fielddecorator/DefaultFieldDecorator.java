package com.liepin.driver.annotation.fielddecorator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.liepin.driver.annotation.PageElement;
import com.liepin.driver.annotation.elementlocator.ElementLocator;
import com.liepin.driver.annotation.elementlocator.ElementLocatorFactory;

public class DefaultFieldDecorator implements FieldDecorator {

    protected ElementLocatorFactory factory;

    public DefaultFieldDecorator(ElementLocatorFactory factory) {
        this.factory = factory;
    }

    public PageElement decorate(ClassLoader loader, Field field) {
        if (!(PageElement.class.isAssignableFrom(field.getType()))) {
            return null;
        }

        ElementLocator locator = factory.createLocator(field);
        if (locator == null) {
            return null;
        }

        if (PageElement.class.isAssignableFrom(field.getType())) {
            return proxyForLocator(loader, locator);
        } else {
            return null;
        }
    }

    protected PageElement proxyForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new LocatingElementHandler(locator);

        PageElement proxy;
        proxy = (PageElement) Proxy.newProxyInstance(loader, new Class[] { PageElement.class }, handler);
        
        return proxy;
    }

}
