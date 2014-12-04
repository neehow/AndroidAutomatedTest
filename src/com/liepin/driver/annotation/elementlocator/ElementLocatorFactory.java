package com.liepin.driver.annotation.elementlocator;

import java.lang.reflect.Field;

public interface ElementLocatorFactory {

    /**
     * When a field on a class needs to be decorated with an
     * {@link ElementLocator} this method will be called.
     * 
     * @param field
     * @return An ElementLocator object.
     */
    ElementLocator createLocator(Field field);
}
