package com.liepin.driver.annotation.elementlocator;

import com.liepin.driver.annotation.PageElement;

public interface SearchContext {

    /**
     * Find the first {@link WebElement} using the given method.
     * 
     * @param by
     *            The locating mechanism
     * @return The first matching element on the current context
     * @throws NoSuchElementException
     *             If no matching elements are found
     */
    PageElement findPageElement(int id);
}
