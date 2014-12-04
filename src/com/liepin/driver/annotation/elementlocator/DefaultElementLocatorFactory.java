package com.liepin.driver.annotation.elementlocator;

import java.lang.reflect.Field;

public class DefaultElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext searchContext;

    public DefaultElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    public ElementLocator createLocator(Field field) {
        return new DefaultElementLocator(searchContext, field);
    }
}
