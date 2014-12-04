package com.liepin.driver.annotation.elementlocator;

import java.lang.reflect.Field;

import com.liepin.driver.annotation.Annotations;
import com.liepin.driver.annotation.PageElement;

public class DefaultElementLocator implements ElementLocator {

    private final SearchContext searchContext;
    private final int           by;

    /**
     * Creates a new element locator.
     * 
     * @param searchContext
     *            The context to use when finding the element
     * @param field
     *            The field on the Page Object that will hold the located value
     */
    public DefaultElementLocator(SearchContext searchContext, Field field) {
        this.searchContext = searchContext;
        Annotations annotations = new Annotations(field);
        by = annotations.buildBy();
    }

    /**
     * Find the element.
     */
    public PageElement findElement() {
        return searchContext.findPageElement(by);
    }
}
