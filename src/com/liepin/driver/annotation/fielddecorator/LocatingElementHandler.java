package com.liepin.driver.annotation.fielddecorator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.liepin.driver.annotation.PageElement;
import com.liepin.driver.annotation.elementlocator.ElementLocator;

public class LocatingElementHandler implements InvocationHandler {
    private final ElementLocator locator;

    public LocatingElementHandler(ElementLocator locator) {
      this.locator = locator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
      PageElement element = locator.findElement();
      if ("getWrappedElement".equals(method.getName())) {
        return element;
      }

      try {
        return method.invoke(element, objects);
      } catch (InvocationTargetException e) {
        // Unwrap the underlying exception
        throw e.getCause();
      }
    }
}
