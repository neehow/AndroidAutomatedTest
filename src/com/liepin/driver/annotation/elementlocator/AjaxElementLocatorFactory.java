package com.liepin.driver.annotation.elementlocator;

import java.lang.reflect.Field;

public class AjaxElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext searchContext;
    private int timeoutInSeconds;

    public AjaxElementLocatorFactory(SearchContext searchContext, int timeOutInSeconds) {
        this.searchContext = searchContext;
        this.timeoutInSeconds = timeOutInSeconds;
    }

    public ElementLocator createLocator(Field field) {
        return new AjaxElementLocator(searchContext, field, timeoutInSeconds);
    }
}
